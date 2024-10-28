package br.univates.ticketmasterplus.businessDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Date;

public class DataBaseConnectionManager implements AutoCloseable {

    public final static int MYSQL = 0;
    public final static int POSTGRESQL = 1;
    public final static int SQLITE = 2;

    private Connection connection;

    private String url;
    private String dataBaseName;
    private String user;
    private String password;

    private String scriptPath;

    public DataBaseConnectionManager(int dbms, String dataBaseName, String user, String pw) throws DataBaseException {
        this(dbms, dataBaseName, user, pw, null, null);
    }

    public DataBaseConnectionManager(int dbms, String dataBaseName, String user, String pw, String ip) throws DataBaseException {
        this(dbms, dataBaseName, user, pw, ip, null);
    }

    public DataBaseConnectionManager(int dbms, String dataBaseName, String user, String pw, String ip, String port) throws DataBaseException {
        if (dbms < 0 || dbms > 2) {
            throw new DataBaseException("O número do SGBD está errado: [0] MySQL; [1] PostgreSQL; [2] SQLite.");
        }

        ip = (ip == null ? "localhost" : ip);

        String[] ports = {"3306", "5433", ""};
        port = (port == null ? ports[dbms] : port);

        String[] jdbc = {
            "jdbc:mysql://" + ip + ":" + port + "/" + dataBaseName,
            "jdbc:postgresql://" + ip + ":" + port + "/" + dataBaseName,
            "jdbc:sqlite:" + dataBaseName
        };

        if (dataBaseName == null) {
            throw new DataBaseException("Falta definir o nome da base de dados.");
        }

        if (user == null && pw == null) {
            throw new DataBaseException("Falta definir usuário e senha da base de dados.");
        }

        this.url = jdbc[dbms];
        this.dataBaseName = dataBaseName;
        this.user = user;
        this.password = pw;
    }

    public void connectDataBase() throws DataBaseException {
        try {
            if (user == null || user.isEmpty()) {
                this.connection = DriverManager.getConnection(url);
            } else {
                this.connection = DriverManager.getConnection(url, this.user, this.password);
            }
        } catch (SQLException ex) {
            throw new DataBaseException("A conexão com o banco de dados falhou: " + ex.getMessage());
        }
    }

    public void connectionTest() throws DataBaseException {
        try (Connection testConnection = DriverManager.getConnection(url, user, password)) {
            // Conexão bem-sucedida
        } catch (SQLException ex) {
            throw new DataBaseException("O teste de conexão com o banco de dados falhou: " + ex.getMessage());
        }
    }

    public void runSQL(String sql) throws DataBaseException {
        if (this.connection == null || isConnectionClosed()) {
            this.connectDataBase();
        }
        executeSQL(sql);
    }

    public void runPreparedSQL(String sql, Object... args) throws DataBaseException {
        if (this.connection == null || isConnectionClosed()) {
            this.connectDataBase();
        }
        executePreparedSQL(sql, args);
    }

    public ResultSet runQuerySQL(String sql) throws DataBaseException {
        if (this.connection == null || isConnectionClosed()) {
            this.connectDataBase();
        }
        return executeQuerySQL(sql);
    }

    public ResultSet runPreparedQuerySQL(String sql, Object... args) throws DataBaseException {
        if (this.connection == null || isConnectionClosed()) {
            this.connectDataBase();
        }
        return executePreparedQuerySQL(sql, args);
    }

    public Connection getConnection() throws DataBaseException {
        if (this.connection == null || isConnectionClosed()) {
            this.connectDataBase();
        }
        return connection;
    }

    private boolean isConnectionClosed() throws DataBaseException {
        try {
            return this.connection.isClosed();
        } catch (SQLException ex) {
            throw new DataBaseException("Erro ao verificar o estado da conexão: " + ex.getMessage());
        }
    }

    @Override
    public void close() throws DataBaseException {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                throw new DataBaseException("Erro ao fechar a conexão com o banco de dados: " + ex.getMessage());
            }
        }
    }

    public void executeSQL(String sql) throws DataBaseException {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            throw new DataBaseException("Erro na execução da instrução SQL: " + ex.getMessage());
        }
    }

    public ResultSet executeQuerySQL(String sql) throws DataBaseException {
        try (Statement stmt = connection.createStatement()) {
            return stmt.executeQuery(sql);
        } catch (SQLException ex) {
            throw new DataBaseException("Erro na execução da consulta SQL: " + ex.getMessage());
        }
    }

    public void executePreparedSQL(String sql, Object... args) throws DataBaseException {
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            setParameters(pstmt, args);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            throw new DataBaseException("Erro na execução da instrução SQL preparada: " + ex.getMessage());
        }
    }

    public ResultSet executePreparedQuerySQL(String sql, Object... args) throws DataBaseException {
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            setParameters(pstmt, args);
            return pstmt.executeQuery();
        } catch (SQLException ex) {
            throw new DataBaseException("Erro na execução da consulta SQL preparada: " + ex.getMessage());
        }
    }

    private void setParameters(PreparedStatement pstmt, Object... args) throws SQLException {
        for (int i = 0; i < args.length; i++) {
            Object param = args[i];
            if (param instanceof Date) {
                pstmt.setDate(i + 1, new java.sql.Date(((Date) param).getTime()));
            } else if (param instanceof Integer) {
                pstmt.setInt(i + 1, (Integer) param);
            } else if (param instanceof Double) {
                pstmt.setDouble(i + 1, (Double) param);
            } else if (param instanceof String) {
                pstmt.setString(i + 1, (String) param);
            } else {
                pstmt.setObject(i + 1, param);
            }
        }
    }

    public void setScriptPath(String scriptPath) {
        this.scriptPath = scriptPath;
    }

    public void runScriptSQL() throws DataBaseException {
        if (this.scriptPath != null && !this.scriptPath.isEmpty()) {
            InputStream is = getClass().getResourceAsStream(this.scriptPath);
            if (is == null) {
                throw new DataBaseException("Não foi possível encontrar o script SQL no caminho especificado.");
            }
            this.runScriptSQL(is);
        } else {
            throw new DataBaseException("Caminho do script SQL não foi definido.");
        }
    }

    public void runScriptSQL(InputStream is) throws DataBaseException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            StringBuilder sql = new StringBuilder();
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                linha = linha.trim();
                // Ignorar comentários e linhas vazias
                if (linha.isEmpty() || linha.startsWith("--") || linha.startsWith("#")) {
                    continue;
                }
                sql.append(" ").append(linha);
                // Se a linha terminar com ';', executa o comando
                if (linha.endsWith(";")) {
                    executeSQL(sql.toString());
                    sql.setLength(0);
                }
            }
            // Executa qualquer comando restante
            if (sql.length() > 0) {
                executeSQL(sql.toString());
            }
        } catch (IOException ex) {
            throw new DataBaseException("Falha ao ler o script SQL: " + ex.getMessage());
        }
    }

    int executePreparedUpdate(String sqlUpdate, String nome, String telefone, String email, String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}