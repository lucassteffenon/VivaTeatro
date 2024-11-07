package br.univates.ticketmasterplus.presentationGUI;

import br.univates.ticketmasterplus.business.Event;
import br.univates.ticketmasterplus.business.SeatReservation;
import br.univates.ticketmasterplus.business.User;
import br.univates.ticketmasterplus.businessDAO.TicketMasterPlusDAO;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class BuyTickets extends javax.swing.JFrame {

    private Event evento;
    private User user;
    
    public BuyTickets(Event eventoRecebido, User userR) {
        initComponents();
        this.evento = eventoRecebido;
        this.user = userR;
        setSeats();
    }

    private void setSeats(){
        TicketMasterPlusDAO dao = new TicketMasterPlusDAO();
        
        // Criar um ArrayList para armazenar os botões
        ArrayList<JButton> botoes = new ArrayList<>();

        // Adicionar todos os botões ao ArrayList
        botoes.add(A1);
        botoes.add(A2);
        botoes.add(A3);
        botoes.add(A4);
        botoes.add(A5);
        botoes.add(A6);
        botoes.add(B7);
        botoes.add(B8);
        botoes.add(B9);
        botoes.add(B10);
        botoes.add(B11);
        botoes.add(B12);
        botoes.add(C13);
        botoes.add(C14);
        botoes.add(C15);
        botoes.add(C16);
        botoes.add(C17);
        botoes.add(C18);
        botoes.add(D19);
        botoes.add(D20);
        botoes.add(D21);
        botoes.add(D22);
        botoes.add(D23);
        botoes.add(D24);
        botoes.add(E25);
        botoes.add(E26);
        botoes.add(E27);
        botoes.add(E28);
        botoes.add(E29);
        botoes.add(E30);
        botoes.add(F31);
        botoes.add(F32);
        botoes.add(F33);
        botoes.add(F34);
        botoes.add(F35);
        botoes.add(F36);
        botoes.add(G37);
        botoes.add(G38);
        botoes.add(G39);
        botoes.add(G40);
        botoes.add(G41);
        botoes.add(G42);
        botoes.add(H43);
        botoes.add(H44);
        botoes.add(H45);
        botoes.add(H46);
        botoes.add(H47);
        botoes.add(H48);
        botoes.add(I49);
        botoes.add(I50);
        botoes.add(I51);
        botoes.add(I52);
        botoes.add(I53);
        botoes.add(I54);
        botoes.add(J55);
        botoes.add(J56);
        botoes.add(J57);
        botoes.add(J58);
        botoes.add(J59);
        botoes.add(J60);

        
        // Configuração do Timer para atualizar a lista a cada 10 segundos
            Timer timer = new Timer(2000, e -> {
                
                    ArrayList<SeatReservation> sr = new ArrayList<>(dao.getAllSeatReservation(this.evento.getIdEvent()));
                
                    // Percorrer a lista e alterar a cor de fundo dos botões
                    for (int i = 0; i < botoes.size() && i < sr.size(); i++) {
                        JButton botao = botoes.get(i);
                        String status = sr.get(i).getStatus();

                        if (status.equals("disponivel")) {
                            botao.setBackground(Color.GREEN);
                        } else if (status.equals("reservado")) {
                            botao.setBackground(Color.YELLOW);
                        } else if (status.equals("vendido")) {
                            botao.setBackground(Color.RED);
                        }
                    }
                
            });
            timer.start();
        
    }
    
    private void reserve(int idS){
        TicketMasterPlusDAO dao = new TicketMasterPlusDAO();
        SeatReservation sr = dao.getSeatReservationStatus(this.evento.getIdEvent(), idS);
        String status = sr.getStatus();
        int idUserSeat = sr.getIdUser();
        if (status.equals("disponivel")) {
            dao.reserveTicket(idS, this.evento.getIdEvent(), "reservado", this.user.getId());
        } else if (status.equals("reservado")) {
            if (idUserSeat == this.user.getId()) {
                dao.reserveTicket(idS, this.evento.getIdEvent(), "disponivel", this.user.getId());
            } else {
                JOptionPane.showMessageDialog(null, "Another user have already reserved this seat.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        A1 = new javax.swing.JButton();
        A2 = new javax.swing.JButton();
        A3 = new javax.swing.JButton();
        A4 = new javax.swing.JButton();
        A5 = new javax.swing.JButton();
        A6 = new javax.swing.JButton();
        B7 = new javax.swing.JButton();
        B12 = new javax.swing.JButton();
        B11 = new javax.swing.JButton();
        B10 = new javax.swing.JButton();
        B9 = new javax.swing.JButton();
        B8 = new javax.swing.JButton();
        C13 = new javax.swing.JButton();
        C14 = new javax.swing.JButton();
        C15 = new javax.swing.JButton();
        C16 = new javax.swing.JButton();
        C17 = new javax.swing.JButton();
        C18 = new javax.swing.JButton();
        D24 = new javax.swing.JButton();
        D20 = new javax.swing.JButton();
        D23 = new javax.swing.JButton();
        D19 = new javax.swing.JButton();
        D21 = new javax.swing.JButton();
        D22 = new javax.swing.JButton();
        E30 = new javax.swing.JButton();
        E28 = new javax.swing.JButton();
        E26 = new javax.swing.JButton();
        E29 = new javax.swing.JButton();
        E25 = new javax.swing.JButton();
        E27 = new javax.swing.JButton();
        F31 = new javax.swing.JButton();
        F32 = new javax.swing.JButton();
        F33 = new javax.swing.JButton();
        F34 = new javax.swing.JButton();
        F35 = new javax.swing.JButton();
        F36 = new javax.swing.JButton();
        H43 = new javax.swing.JButton();
        H44 = new javax.swing.JButton();
        H45 = new javax.swing.JButton();
        H46 = new javax.swing.JButton();
        H47 = new javax.swing.JButton();
        H48 = new javax.swing.JButton();
        G38 = new javax.swing.JButton();
        G37 = new javax.swing.JButton();
        G40 = new javax.swing.JButton();
        G41 = new javax.swing.JButton();
        G39 = new javax.swing.JButton();
        G42 = new javax.swing.JButton();
        I49 = new javax.swing.JButton();
        I50 = new javax.swing.JButton();
        I51 = new javax.swing.JButton();
        I52 = new javax.swing.JButton();
        I53 = new javax.swing.JButton();
        I54 = new javax.swing.JButton();
        J55 = new javax.swing.JButton();
        J56 = new javax.swing.JButton();
        J57 = new javax.swing.JButton();
        J58 = new javax.swing.JButton();
        J59 = new javax.swing.JButton();
        J60 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(30, 30));

        jPanel1.setBackground(new java.awt.Color(102, 51, 0));

        jLabel1.setText("Stage");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jLabel2.setText("A");

        jLabel3.setText("B");

        A1.setBackground(new java.awt.Color(153, 153, 153));
        A1.setForeground(new java.awt.Color(255, 255, 255));
        A1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A1ActionPerformed(evt);
            }
        });

        A2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A2ActionPerformed(evt);
            }
        });

        A3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A3ActionPerformed(evt);
            }
        });

        A4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A4ActionPerformed(evt);
            }
        });

        A5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A5ActionPerformed(evt);
            }
        });

        A6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A6ActionPerformed(evt);
            }
        });

        B7.setForeground(new java.awt.Color(0, 255, 0));
        B7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B7ActionPerformed(evt);
            }
        });

        B12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B12ActionPerformed(evt);
            }
        });

        B11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B11ActionPerformed(evt);
            }
        });

        B10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B10ActionPerformed(evt);
            }
        });

        B9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B9ActionPerformed(evt);
            }
        });

        B8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B8ActionPerformed(evt);
            }
        });

        C13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C13ActionPerformed(evt);
            }
        });

        C14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C14ActionPerformed(evt);
            }
        });

        C15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C15ActionPerformed(evt);
            }
        });

        C16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C16ActionPerformed(evt);
            }
        });

        C17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C17ActionPerformed(evt);
            }
        });

        C18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C18ActionPerformed(evt);
            }
        });

        D24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D24ActionPerformed(evt);
            }
        });

        D20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D20ActionPerformed(evt);
            }
        });

        D23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D23ActionPerformed(evt);
            }
        });

        D19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D19ActionPerformed(evt);
            }
        });

        D21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D21ActionPerformed(evt);
            }
        });

        D22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D22ActionPerformed(evt);
            }
        });

        E30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                E30ActionPerformed(evt);
            }
        });

        E28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                E28ActionPerformed(evt);
            }
        });

        E26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                E26ActionPerformed(evt);
            }
        });

        E29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                E29ActionPerformed(evt);
            }
        });

        E25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                E25ActionPerformed(evt);
            }
        });

        E27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                E27ActionPerformed(evt);
            }
        });

        F31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F31ActionPerformed(evt);
            }
        });

        F32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F32ActionPerformed(evt);
            }
        });

        F33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F33ActionPerformed(evt);
            }
        });

        F34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F34ActionPerformed(evt);
            }
        });

        F35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F35ActionPerformed(evt);
            }
        });

        F36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F36ActionPerformed(evt);
            }
        });

        H43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H43ActionPerformed(evt);
            }
        });

        H44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H44ActionPerformed(evt);
            }
        });

        H45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H45ActionPerformed(evt);
            }
        });

        H46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H46ActionPerformed(evt);
            }
        });

        H47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H47ActionPerformed(evt);
            }
        });

        H48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H48ActionPerformed(evt);
            }
        });

        G38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G38ActionPerformed(evt);
            }
        });

        G37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G37ActionPerformed(evt);
            }
        });

        G40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G40ActionPerformed(evt);
            }
        });

        G41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G41ActionPerformed(evt);
            }
        });

        G39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G39ActionPerformed(evt);
            }
        });

        G42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G42ActionPerformed(evt);
            }
        });

        I49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I49ActionPerformed(evt);
            }
        });

        I50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I50ActionPerformed(evt);
            }
        });

        I51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I51ActionPerformed(evt);
            }
        });

        I52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I52ActionPerformed(evt);
            }
        });

        I53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I53ActionPerformed(evt);
            }
        });

        I54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I54ActionPerformed(evt);
            }
        });

        J55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                J55ActionPerformed(evt);
            }
        });

        J56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                J56ActionPerformed(evt);
            }
        });

        J57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                J57ActionPerformed(evt);
            }
        });

        J58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                J58ActionPerformed(evt);
            }
        });

        J59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                J59ActionPerformed(evt);
            }
        });

        J60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                J60ActionPerformed(evt);
            }
        });

        jLabel7.setText("C");

        jLabel8.setText("D");

        jLabel9.setText("E");

        jLabel10.setText("F");

        jLabel11.setText("G");

        jLabel12.setText("H");

        jLabel13.setText("I");

        jLabel14.setText("J");

        jLabel15.setText("1");

        jLabel16.setText("2");

        jLabel17.setText("3");

        jLabel18.setText("4");

        jLabel19.setText("5");

        jLabel20.setText("6");

        jButton1.setText("Buy");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(A5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(A4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(A3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(A2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(A1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(A6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(B7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(B10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(B9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(B8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addComponent(B12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(C13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(C14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(C15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(C16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(C17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addComponent(C18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(D20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(D23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(D19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(D21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(D22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addComponent(D24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(E28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(E26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(E29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(E25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(E27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(E30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9))
                .addGap(102, 102, 102)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(F31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(F32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(F33, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(F34, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(F35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addComponent(F36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(G38, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(G37, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(G40, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(G41, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(G39, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addComponent(G42, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(H43, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(H44, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(H45, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(H46, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(H47, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(H48, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(I49, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(I50, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(I51, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(I52, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(I53, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(I54, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(J55, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(J56, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(J57, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(J58, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(J59, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(J60, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(H43, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(H44, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(H45, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(H46, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(H47, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(H48, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(I49, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(I50, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(I51, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(I52, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(I53, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(I54, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(J55, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(J56, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(J57, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(J58, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(J59, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(J60, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel8)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(A1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel15))
                                                                    .addGap(18, 18, 18)
                                                                    .addComponent(A2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(jLabel16))
                                                            .addGap(18, 18, 18)
                                                            .addComponent(A3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jLabel17))
                                                    .addGap(18, 18, 18)
                                                    .addComponent(A4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel18))
                                            .addGap(18, 18, 18)
                                            .addComponent(A5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel19))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(A6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel20)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(C13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(C14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(C15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(C16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(C17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(C18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(B7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(B8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(B9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(B10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(B11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(B12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(D19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(D20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(D21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(D22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(D23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(D24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(F31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(F32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(F33, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(F34, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(F35, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(F36, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(E25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(E26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(E27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(E28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(E29, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(E30, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(G37, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(G38, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(G39, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(G40, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(G41, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(G42, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnBack))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackActionPerformed

    private void A1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_A1ActionPerformed
        // Desabilita o botão no início do evento
        A1.setEnabled(false);
        try{
          this.reserve(1);  
        } finally {
            // Reabilita o botão após a execução do código
            A1.setEnabled(true);
        }
    }//GEN-LAST:event_A1ActionPerformed

    private void A2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_A2ActionPerformed
        // Desabilita o botão no início do evento
        A2.setEnabled(false);
        try{
          this.reserve(2);  
        } finally {
            // Reabilita o botão após a execução do código
            A2.setEnabled(true);
        }
    }//GEN-LAST:event_A2ActionPerformed

    private void A3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_A3ActionPerformed
        // Desabilita o botão no início do evento
        A3.setEnabled(false);
        try{
          this.reserve(3);  
        } finally {
            // Reabilita o botão após a execução do código
            A3.setEnabled(true);
        }
    }//GEN-LAST:event_A3ActionPerformed

    private void A4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_A4ActionPerformed
        // Desabilita o botão no início do evento
        A4.setEnabled(false);
        try{
          this.reserve(4);  
        } finally {
            // Reabilita o botão após a execução do código
            A4.setEnabled(true);
        }
    }//GEN-LAST:event_A4ActionPerformed

    private void A5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_A5ActionPerformed
        // Desabilita o botão no início do evento
        A5.setEnabled(false);
        try{
          this.reserve(5);  
        } finally {
            // Reabilita o botão após a execução do código
            A5.setEnabled(true);
        }
    }//GEN-LAST:event_A5ActionPerformed

    private void A6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_A6ActionPerformed
        // Desabilita o botão no início do evento
        A6.setEnabled(false);
        try{
          this.reserve(6);  
        } finally {
            // Reabilita o botão após a execução do código
            A6.setEnabled(true);
        }
    }//GEN-LAST:event_A6ActionPerformed

    private void B7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B7ActionPerformed
        // Desabilita o botão no início do evento
        B7.setEnabled(false);
        try{
          this.reserve(7);  
        } finally {
            // Reabilita o botão após a execução do código
            B7.setEnabled(true);
        }
    }//GEN-LAST:event_B7ActionPerformed

    private void B8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B8ActionPerformed
        // Desabilita o botão no início do evento
        B8.setEnabled(false);
        try{
          this.reserve(8);  
        } finally {
            // Reabilita o botão após a execução do código
            B8.setEnabled(true);
        }
    }//GEN-LAST:event_B8ActionPerformed

    private void B9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B9ActionPerformed
        // Desabilita o botão no início do evento
        B9.setEnabled(false);
        try{
          this.reserve(9);  
        } finally {
            // Reabilita o botão após a execução do código
            B9.setEnabled(true);
        }
    }//GEN-LAST:event_B9ActionPerformed

    private void B10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B10ActionPerformed
        // Desabilita o botão no início do evento
        B10.setEnabled(false);
        try{
          this.reserve(10);  
        } finally {
            // Reabilita o botão após a execução do código
            B10.setEnabled(true);
        }
    }//GEN-LAST:event_B10ActionPerformed

    private void B11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B11ActionPerformed
        // Desabilita o botão no início do evento
        B11.setEnabled(false);
        try{
          this.reserve(11);  
        } finally {
            // Reabilita o botão após a execução do código
            B11.setEnabled(true);
        }
    }//GEN-LAST:event_B11ActionPerformed

    private void B12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B12ActionPerformed
        // Desabilita o botão no início do evento
        B12.setEnabled(false);
        try{
          this.reserve(12);  
        } finally {
            // Reabilita o botão após a execução do código
            B12.setEnabled(true);
        }
    }//GEN-LAST:event_B12ActionPerformed

    private void C13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C13ActionPerformed
        // Desabilita o botão no início do evento
        C13.setEnabled(false);
        try{
          this.reserve(13);  
        } finally {
            // Reabilita o botão após a execução do código
            C13.setEnabled(true);
        }
    }//GEN-LAST:event_C13ActionPerformed

    private void C14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C14ActionPerformed

        // Desabilita o botão no início do evento
        C14.setEnabled(false);
        try{
          this.reserve(14);  
        } finally {
            // Reabilita o botão após a execução do código
            C14.setEnabled(true);
        }
    }//GEN-LAST:event_C14ActionPerformed

    private void C15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C15ActionPerformed
        // Desabilita o botão no início do evento
        C15.setEnabled(false);
        try{
          this.reserve(15);  
        } finally {
            // Reabilita o botão após a execução do código
            C15.setEnabled(true);
        }
    }//GEN-LAST:event_C15ActionPerformed

    private void C16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C16ActionPerformed
        // Desabilita o botão no início do evento
        C16.setEnabled(false);
        try{
          this.reserve(16);  
        } finally {
            // Reabilita o botão após a execução do código
            C16.setEnabled(true);
        }
    }//GEN-LAST:event_C16ActionPerformed

    private void C17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C17ActionPerformed
        // Desabilita o botão no início do evento
        C17.setEnabled(false);
        try{
          this.reserve(17);  
        } finally {
            // Reabilita o botão após a execução do código
            C17.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_C17ActionPerformed

    private void C18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C18ActionPerformed
        // Desabilita o botão no início do evento
        C18.setEnabled(false);
        try{
          this.reserve(18);  
        } finally {
            // Reabilita o botão após a execução do código
            C18.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_C18ActionPerformed

    private void D19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_D19ActionPerformed
        // Desabilita o botão no início do evento
        D19.setEnabled(false);
        try{
          this.reserve(19);  
        } finally {
            // Reabilita o botão após a execução do código
            D19.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_D19ActionPerformed

    private void D20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_D20ActionPerformed
        // Desabilita o botão no início do evento
        D20.setEnabled(false);
        try{
          this.reserve(20);  
        } finally {
            // Reabilita o botão após a execução do código
            D20.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_D20ActionPerformed

    private void D21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_D21ActionPerformed
        // Desabilita o botão no início do evento
        D21.setEnabled(false);
        try{
          this.reserve(21);  
        } finally {
            // Reabilita o botão após a execução do código
            D21.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_D21ActionPerformed

    private void D22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_D22ActionPerformed
        // Desabilita o botão no início do evento
        D22.setEnabled(false);
        try{
          this.reserve(22);  
        } finally {
            // Reabilita o botão após a execução do código
            D22.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_D22ActionPerformed

    private void D23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_D23ActionPerformed
        // Desabilita o botão no início do evento
        D23.setEnabled(false);
        try{
          this.reserve(23);  
        } finally {
            // Reabilita o botão após a execução do código
            D23.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_D23ActionPerformed

    private void D24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_D24ActionPerformed
        // Desabilita o botão no início do evento
        D24.setEnabled(false);
        try{
          this.reserve(24);  
        } finally {
            // Reabilita o botão após a execução do código
            D24.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_D24ActionPerformed

    private void E25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_E25ActionPerformed
        // Desabilita o botão no início do evento
        E25.setEnabled(false);
        try{
          this.reserve(25);  
        } finally {
            // Reabilita o botão após a execução do código
            E25.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_E25ActionPerformed

    private void E26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_E26ActionPerformed
        // Desabilita o botão no início do evento
        E26.setEnabled(false);
        try{
          this.reserve(26);  
        } finally {
            // Reabilita o botão após a execução do código
            E26.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_E26ActionPerformed

    private void E27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_E27ActionPerformed
        // Desabilita o botão no início do evento
        E27.setEnabled(false);
        try{
          this.reserve(27);  
        } finally {
            // Reabilita o botão após a execução do código
            E27.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_E27ActionPerformed

    private void E28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_E28ActionPerformed
        // Desabilita o botão no início do evento
        E28.setEnabled(false);
        try{
          this.reserve(28);  
        } finally {
            // Reabilita o botão após a execução do código
            E28.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_E28ActionPerformed

    private void E29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_E29ActionPerformed
        // Desabilita o botão no início do evento
        E29.setEnabled(false);
        try{
          this.reserve(29);  
        } finally {
            // Reabilita o botão após a execução do código
            E29.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_E29ActionPerformed

    private void E30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_E30ActionPerformed
        // Desabilita o botão no início do evento
        E30.setEnabled(false);
        try{
          this.reserve(30);  
        } finally {
            // Reabilita o botão após a execução do código
            E30.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_E30ActionPerformed

    private void F31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_F31ActionPerformed
        // Desabilita o botão no início do evento
        F31.setEnabled(false);
        try{
          this.reserve(31);  
        } finally {
            // Reabilita o botão após a execução do código
            F31.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_F31ActionPerformed

    private void F32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_F32ActionPerformed
        // Desabilita o botão no início do evento
        F32.setEnabled(false);
        try{
          this.reserve(32);  
        } finally {
            // Reabilita o botão após a execução do código
            F32.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_F32ActionPerformed

    private void F33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_F33ActionPerformed
        // Desabilita o botão no início do evento
        F33.setEnabled(false);
        try{
          this.reserve(33);  
        } finally {
            // Reabilita o botão após a execução do código
            F33.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_F33ActionPerformed

    private void F34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_F34ActionPerformed
        // Desabilita o botão no início do evento
        F34.setEnabled(false);
        try{
          this.reserve(34);  
        } finally {
            // Reabilita o botão após a execução do código
            F34.setEnabled(true);
        }
    // TODO add your handling code here:
    }//GEN-LAST:event_F34ActionPerformed

    private void F35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_F35ActionPerformed
        // Desabilita o botão no início do evento
        F35.setEnabled(false);
        try{
          this.reserve(35);  
        } finally {
            // Reabilita o botão após a execução do código
            F35.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_F35ActionPerformed

    private void F36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_F36ActionPerformed
        // Desabilita o botão no início do evento
        F36.setEnabled(false);
        try{
          this.reserve(36);  
        } finally {
            // Reabilita o botão após a execução do código
            F36.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_F36ActionPerformed

    private void G37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_G37ActionPerformed
// Desabilita o botão no início do evento
        G37.setEnabled(false);
        try{
          this.reserve(37);  
        } finally {
            // Reabilita o botão após a execução do código
            G37.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_G37ActionPerformed

    private void G38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_G38ActionPerformed
        // Desabilita o botão no início do evento
        G38.setEnabled(false);
        try{
          this.reserve(38);  
        } finally {
            // Reabilita o botão após a execução do código
            G38.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_G38ActionPerformed

    private void G39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_G39ActionPerformed
        // Desabilita o botão no início do evento
        G39.setEnabled(false);
        try{
          this.reserve(39);  
        } finally {
            // Reabilita o botão após a execução do código
            G39.setEnabled(true);
        }
            // TODO add your handling code here:
    }//GEN-LAST:event_G39ActionPerformed

    private void G40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_G40ActionPerformed
        // Desabilita o botão no início do evento
        G40.setEnabled(false);
        try{
          this.reserve(40);  
        } finally {
            // Reabilita o botão após a execução do código
            G40.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_G40ActionPerformed

    private void G41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_G41ActionPerformed
        // Desabilita o botão no início do evento
        G41.setEnabled(false);
        try{
          this.reserve(41);  
        } finally {
            // Reabilita o botão após a execução do código
            G41.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_G41ActionPerformed

    private void G42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_G42ActionPerformed
        // Desabilita o botão no início do evento
        G42.setEnabled(false);
        try{
          this.reserve(42);  
        } finally {
            // Reabilita o botão após a execução do código
            G42.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_G42ActionPerformed

    private void H43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H43ActionPerformed
        // Desabilita o botão no início do evento
        H43.setEnabled(false);
        try{
          this.reserve(43);  
        } finally {
            // Reabilita o botão após a execução do código
            H43.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_H43ActionPerformed

    private void H44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H44ActionPerformed
        // Desabilita o botão no início do evento
        H44.setEnabled(false);
        try{
          this.reserve(44);  
        } finally {
            // Reabilita o botão após a execução do código
            H44.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_H44ActionPerformed

    private void H45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H45ActionPerformed
        // Desabilita o botão no início do evento
        H45.setEnabled(false);
        try{
          this.reserve(45);  
        } finally {
            // Reabilita o botão após a execução do código
            H45.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_H45ActionPerformed

    private void H46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H46ActionPerformed
        // Desabilita o botão no início do evento
        H46.setEnabled(false);
        try{
          this.reserve(46);  
        } finally {
            // Reabilita o botão após a execução do código
            H46.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_H46ActionPerformed

    private void H47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H47ActionPerformed
        // Desabilita o botão no início do evento
        H47.setEnabled(false);
        try{
          this.reserve(47);  
        } finally {
            // Reabilita o botão após a execução do código
            H47.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_H47ActionPerformed

    private void H48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H48ActionPerformed
        // Desabilita o botão no início do evento
        H48.setEnabled(false);
        try{
          this.reserve(48);  
        } finally {
            // Reabilita o botão após a execução do código
            H48.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_H48ActionPerformed

    private void I49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I49ActionPerformed
        // Desabilita o botão no início do evento
        I49.setEnabled(false);
        try{
          this.reserve(49);  
        } finally {
            // Reabilita o botão após a execução do código
            I49.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_I49ActionPerformed

    private void I50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I50ActionPerformed
        // Desabilita o botão no início do evento
        I50.setEnabled(false);
        try{
          this.reserve(50);  
        } finally {
            // Reabilita o botão após a execução do código
            I50.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_I50ActionPerformed

    private void I51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I51ActionPerformed
        // Desabilita o botão no início do evento
        I51.setEnabled(false);
        try{
          this.reserve(51);  
        } finally {
            // Reabilita o botão após a execução do código
            I51.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_I51ActionPerformed

    private void I52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I52ActionPerformed
        // Desabilita o botão no início do evento
        I52.setEnabled(false);
        try{
          this.reserve(52);  
        } finally {
            // Reabilita o botão após a execução do código
            I52.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_I52ActionPerformed

    private void I53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I53ActionPerformed
        // Desabilita o botão no início do evento
        I53.setEnabled(false);
        try{
          this.reserve(53);  
        } finally {
            // Reabilita o botão após a execução do código
            I53.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_I53ActionPerformed

    private void I54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I54ActionPerformed
        // Desabilita o botão no início do evento
        I54.setEnabled(false);
        try{
          this.reserve(54);  
        } finally {
            // Reabilita o botão após a execução do código
            I54.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_I54ActionPerformed

    private void J55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_J55ActionPerformed
        // Desabilita o botão no início do evento
        J55.setEnabled(false);
        try{
          this.reserve(55);  
        } finally {
            // Reabilita o botão após a execução do código
            J55.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_J55ActionPerformed

    private void J56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_J56ActionPerformed
        // Desabilita o botão no início do evento
        J56.setEnabled(false);
        try{
          this.reserve(56);  
        } finally {
            // Reabilita o botão após a execução do código
            J56.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_J56ActionPerformed

    private void J57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_J57ActionPerformed
        // Desabilita o botão no início do evento
        J57.setEnabled(false);
        try{
          this.reserve(57);  
        } finally {
            // Reabilita o botão após a execução do código
            J57.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_J57ActionPerformed

    private void J58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_J58ActionPerformed
        // Desabilita o botão no início do evento
        J58.setEnabled(false);
        try{
          this.reserve(58);  
        } finally {
            // Reabilita o botão após a execução do código
            J58.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_J58ActionPerformed

    private void J59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_J59ActionPerformed
        // Desabilita o botão no início do evento
        J59.setEnabled(false);
        try{
          this.reserve(59);  
        } finally {
            // Reabilita o botão após a execução do código
            J59.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_J59ActionPerformed

    private void J60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_J60ActionPerformed
        // Desabilita o botão no início do evento
        J60.setEnabled(false);
        try{
          this.reserve(60);  
        } finally {
            // Reabilita o botão após a execução do código
            J60.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_J60ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton A1;
    private javax.swing.JButton A2;
    private javax.swing.JButton A3;
    private javax.swing.JButton A4;
    private javax.swing.JButton A5;
    private javax.swing.JButton A6;
    private javax.swing.JButton B10;
    private javax.swing.JButton B11;
    private javax.swing.JButton B12;
    private javax.swing.JButton B7;
    private javax.swing.JButton B8;
    private javax.swing.JButton B9;
    private javax.swing.JButton C13;
    private javax.swing.JButton C14;
    private javax.swing.JButton C15;
    private javax.swing.JButton C16;
    private javax.swing.JButton C17;
    private javax.swing.JButton C18;
    private javax.swing.JButton D19;
    private javax.swing.JButton D20;
    private javax.swing.JButton D21;
    private javax.swing.JButton D22;
    private javax.swing.JButton D23;
    private javax.swing.JButton D24;
    private javax.swing.JButton E25;
    private javax.swing.JButton E26;
    private javax.swing.JButton E27;
    private javax.swing.JButton E28;
    private javax.swing.JButton E29;
    private javax.swing.JButton E30;
    private javax.swing.JButton F31;
    private javax.swing.JButton F32;
    private javax.swing.JButton F33;
    private javax.swing.JButton F34;
    private javax.swing.JButton F35;
    private javax.swing.JButton F36;
    private javax.swing.JButton G37;
    private javax.swing.JButton G38;
    private javax.swing.JButton G39;
    private javax.swing.JButton G40;
    private javax.swing.JButton G41;
    private javax.swing.JButton G42;
    private javax.swing.JButton H43;
    private javax.swing.JButton H44;
    private javax.swing.JButton H45;
    private javax.swing.JButton H46;
    private javax.swing.JButton H47;
    private javax.swing.JButton H48;
    private javax.swing.JButton I49;
    private javax.swing.JButton I50;
    private javax.swing.JButton I51;
    private javax.swing.JButton I52;
    private javax.swing.JButton I53;
    private javax.swing.JButton I54;
    private javax.swing.JButton J55;
    private javax.swing.JButton J56;
    private javax.swing.JButton J57;
    private javax.swing.JButton J58;
    private javax.swing.JButton J59;
    private javax.swing.JButton J60;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
