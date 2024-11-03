/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.ticketmasterplus.businessDAO;

import br.univates.ticketmasterplus.business.Event;
import br.univates.ticketmasterplus.business.Seat;
import br.univates.ticketmasterplus.business.SeatReservation;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author lucassteffenon
 */
public class TicketMasterPlusDAO {
    
    
    private String ip = "localhost";
    private String port = "5433";
    private String nameDB = "facil";
    private String userDB = "postgres";
    private String pswDB = "postgres";

    public void buyTicket(int idSeat, int idEvent, int idPerson, String status, int valor) {

    }

    public ArrayList<Event> getEventsList() throws SQLException {
        ArrayList<Event> events = new ArrayList<>();
        LocalDate dataExecucao = LocalDate.now();

        String sql = "SELECT * FROM Event WHERE startdate >= ?";

        try (DataBaseConnectionManager db = new DataBaseConnectionManager(1, this.nameDB, this.userDB, this.pswDB)) {
            db.connectDataBase();

            try (PreparedStatement stmt = db.getConnection().prepareStatement(sql)) {
                stmt.setDate(1, java.sql.Date.valueOf(dataExecucao));

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    int idEvent = rs.getInt("idevent");
                    String eventDescription = rs.getString("eventdescription");
                    String eventName = rs.getString("eventname");
                    String startDate = rs.getString("startdate");
                    String startHour = rs.getString("starthour");
                    String endDate = rs.getString("enddate");
                    String endHour = rs.getString("endhour");
                    int numberSeats = rs.getInt("numberseats");
                    int basePrice = rs.getInt("baseprice");

                    Event evento = new Event();
                    evento.setIdEvent(idEvent);
                    evento.setName(eventName);
                    evento.setDescription(eventDescription);
                    evento.setStartDate(startDate);
                    evento.setStartHour(startHour);
                    evento.setEndDate(endDate);
                    evento.setEndHour(endHour);
                    evento.setSeatsNumber(numberSeats);
                    evento.setBasePrice(basePrice);
                    events.add(evento);
                }
            }
        } catch (DataBaseException ex) {
            Logger.getLogger(TicketMasterPlusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return events;
    }

    public Event getEvento(String name, String startDate, String startHour) {
        Event evento = null;
        String sql = "SELECT * FROM Event WHERE eventname = '"+name+"' AND startdate = '"+startDate+"' AND starthour = '"+startHour+"'";

        Conexao con = new Conexao("PostgreSql", this.ip, this.port, this.nameDB, this.userDB, this.pswDB);
        try {
            con.conect();
            ResultSet rs = con.query(sql);
            if (rs.next()) {
                evento = new Event();
                int idEvento = rs.getInt("idevent");
                String eventDescription = rs.getString("eventdescription");
                String eventName = rs.getString("eventname");
                String sDate = rs.getString("startdate");
                String sHour = rs.getString("starthour");
                String endDate = rs.getString("enddate");
                String endHour = rs.getString("endhour");
                int numberSeats = rs.getInt("numberseats");
                int basePrice = rs.getInt("baseprice");

                evento.setIdEvent(idEvento);
                evento.setName(eventName);
                evento.setDescription(eventDescription);
                evento.setStartDate(sDate);
                evento.setStartHour(sHour);
                evento.setEndDate(endDate);
                evento.setEndHour(endHour);
                evento.setSeatsNumber(numberSeats);
                evento.setBasePrice(basePrice);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

        return evento;
    }

    public void createNewEvent(Event evento) {
        int generatedId = -1;
        try (DataBaseConnectionManager db = new DataBaseConnectionManager(1, "facil", "postgres", "postgres")) {
        db.connectDataBase();

        String eventDescription = evento.getDescription();
        String eventName = evento.getName();
        String startDate = evento.getStartDate().replace("/", "-");
        String startHour = evento.getStartHour();
        String endDate = evento.getEndDate().replace("/", "-");
        String endHour = evento.getEndHour();
        int numberSeats = evento.getSeatsNumber();
        int basePrice = evento.getBasePrice();

        String values = "('" + eventDescription + "', '" + eventName + "', '" + startDate + "', '" + startHour + "', '" + endDate + "', '" + endHour + "', " + numberSeats + ", " + basePrice + ")";
        String sql = "INSERT INTO Event (eventDescription, eventName, startDate, startHour, endDate, endHour, numberSeats, basePrice) VALUES " + values;

        try (Statement stmt = db.getConnection().createStatement()) {
            int affectedRows = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        generatedId = generatedKeys.getInt(1);
                    }
                }
            }
        }
        
        this.createEventReservation(generatedId, basePrice);

    } catch (DataBaseException | DateTimeParseException | SQLException ex) {
        Logger.getLogger(TicketMasterPlusDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    public void editEvent(Event evento) {
        
        int idEvent = evento.getIdEvent();
        String eventDescription = evento.getDescription();
        String eventName = evento.getName();
        String startDate = evento.getStartDate();
        String startHour = evento.getStartHour();
        String endDate = evento.getEndDate();
        String endHour = evento.getEndHour();
        int numberSeats = evento.getSeatsNumber();
        int basePrice = evento.getBasePrice();
        
        String sql = "UPDATE event SET eventdescription = '"+ eventDescription + "', eventname = '"+eventName+"', startdate = '"+startDate+"', starthour = '"+startHour+"', enddate = '"+endDate+"', endhour = '"+endHour+"', numberseats = " + numberSeats + ", baseprice = "+ basePrice + " WHERE idevent = '"+idEvent+"'";
       
        Conexao con = new Conexao("PostgreSql", "localhost", "5433", "facil", "postgres", "postgres");
        con.conect();
        con.queryUpdate(sql);
        
    }
    
    public void createEventReservation(int idEvent, int price){
        
        ArrayList<Seat> seats = new ArrayList<>();
        seats = this.getAllSeats();
        
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("INSERT INTO seatreservation (idseat, idevent, price) VALUES\n");

        for (int i = 1; i <= 60; i++) {
            sqlBuilder.append("(").append(i).append(", ").append(idEvent).append(", ").append(price * seats.get(i-1).getMultiplicator()).append(")");
            if (i < 60) {
                sqlBuilder.append(",\n");
            }
        }

        String sql = sqlBuilder.toString();
        
        Conexao con = new Conexao("PostgreSql", this.ip, this.port, this.nameDB, this.userDB, this.pswDB);
        con.conect();
        con.queryUpdate(sql);
        
    }

    public void createNewUser() {

    }

    public void editUser() {

    }

    public void createNewSeat() {

    }

    public void editSeat() {

    }
    
    public ArrayList<Seat> getAllSeats(){
        ArrayList<Seat> seats = new ArrayList<>();
        String sql = "SELECT * FROM seat ORDER BY idseat";
        Conexao con = new Conexao("PostgreSql", this.ip, this.port, this.nameDB, this.userDB, this.pswDB);
        try {
            con.conect();
            ResultSet rs = con.query(sql);
            while (rs.next()){
                int id = rs.getInt("idseat");
                String description = rs.getString("seatdescription");
                double multiplicator = rs.getDouble("multiplication");
                String status = rs.getString("status");
                boolean specialPerson = rs.getBoolean("specialperson");
                int posX = rs.getInt("posx");
                int posY = rs.getInt("posy");
                Seat s = new Seat(id, description, multiplicator, status, specialPerson, posX, posY);
                seats.add(s);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
        return seats;
    }
    
    public ArrayList<SeatReservation> getAllSeatReservation(int idE){
        ArrayList<SeatReservation> seatR = new ArrayList<>();
        String sql = "SELECT * FROM seatreservation WHERE idevent = '"+idE+"' ORDER BY idseat";
        Conexao con = new Conexao("PostgreSql", this.ip, this.port, this.nameDB, this.userDB, this.pswDB);
        try {
            con.conect();
            ResultSet rs = con.query(sql);
            while (rs.next()){
                int idSeatReservation = rs.getInt("idseatreservation");
                int idSeat = rs.getInt("idseat");
                int idEvent = rs.getInt("idevent");
                int idPerson = rs.getInt("idperson");
                String status = rs.getString("status");
                double price = rs.getDouble("price");
                SeatReservation sr = new SeatReservation(idSeatReservation, idSeat, idEvent, idPerson, status, price);
                seatR.add(sr);
            } 
        } catch (SQLException ex){
            System.out.println(ex.toString());
        }
        
        return seatR;
    }

}
