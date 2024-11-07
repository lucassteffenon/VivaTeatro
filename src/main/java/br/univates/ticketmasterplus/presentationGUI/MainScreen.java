/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.univates.ticketmasterplus.presentationGUI;

import br.univates.ticketmasterplus.business.Event;
import br.univates.ticketmasterplus.business.User;
import br.univates.ticketmasterplus.businessDAO.TicketMasterPlusDAO;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author lucassteffenon
 */
public class MainScreen extends javax.swing.JFrame {
    
    Event evento = new Event();
    
    private User user;

    public void refreshEventsList() throws SQLException{
        TicketMasterPlusDAO dao = new TicketMasterPlusDAO();
        ArrayList<Event> listaEventosSQL = dao.getEventsList();
        
        this.listaEventos.removeAll();
        DefaultListModel model = new DefaultListModel();
        
        for ( Event evento : listaEventosSQL){
            model.addElement( "Start Date: " + evento.getStartDateFormatada() + ", Start Hour: " + evento.getStartHour() + ", Event Name: " + evento.getName());
        }
        this.listaEventos.setModel(model);
    }
    
    
    
    public MainScreen(User user){
        try {
            this.user = user;
            initComponents();
            this.refreshEventsList();
            
            // Configuração do Timer para atualizar a lista a cada 10 segundos
            Timer timer = new Timer(2000, e -> {
                try {
                    refreshEventsList();
                } catch (SQLException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            timer.start();
        } catch (SQLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnBuyTickets = new javax.swing.JButton();
        btnCreateNewEvent = new javax.swing.JButton();
        btnEditEvent = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaEventos = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        btnBuyTickets.setText("Buy Ticket");
        btnBuyTickets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyTicketsActionPerformed(evt);
            }
        });

        btnCreateNewEvent.setText("Create New Event");
        btnCreateNewEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateNewEventActionPerformed(evt);
            }
        });

        btnEditEvent.setText("Edit Event");
        btnEditEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditEventActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btnBuyTickets))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnCreateNewEvent))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnExit))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btnEditEvent)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(btnBuyTickets)
                .addGap(18, 18, 18)
                .addComponent(btnCreateNewEvent)
                .addGap(18, 18, 18)
                .addComponent(btnEditEvent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addContainerGap())
        );

        listaEventos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaEventos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaEventosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaEventos);

        jLabel1.setText("Events List");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuyTicketsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyTicketsActionPerformed
        
        if (this.evento.getName() != null) {
            TicketMasterPlusDAO dao = new TicketMasterPlusDAO();
            this.evento = dao.getEvento(this.evento.getName(), this.evento.getStartDate(), this.evento.getStartHour());
            BuyTickets bt = new BuyTickets(this.evento, this.user);
            bt.setLocationRelativeTo(null);
            bt.setVisible(true);  
        } else {
            JOptionPane.showMessageDialog(null, "No events selected.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        
        
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuyTicketsActionPerformed

    private void btnCreateNewEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateNewEventActionPerformed
        
        EventScreen es = new EventScreen(this.evento, 0);
        es.setLocationRelativeTo(null);
        es.setVisible(true);
        
    }//GEN-LAST:event_btnCreateNewEventActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void listaEventosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaEventosMouseClicked
        // TODO add your handling code here:
        String startDate = listaEventos.getSelectedValue().substring(12,22).replaceAll("[^0-9]", "");
        String dd = startDate.substring(0, 2);
        String mm = startDate.substring(2, 4);
        String yyyy = startDate.substring(4, 8);
        String dataAmericana = yyyy + "-" + mm + "-" + dd;
        evento.setStartDate(dataAmericana);
        evento.setStartHour(listaEventos.getSelectedValue().substring(36,44));
        evento.setName(listaEventos.getSelectedValue().substring(58));
    }//GEN-LAST:event_listaEventosMouseClicked

    private void btnEditEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditEventActionPerformed
       
       if (this.evento.getName() != null){
            TicketMasterPlusDAO dao = new TicketMasterPlusDAO();
            this.evento = dao.getEvento(this.evento.getName(), this.evento.getStartDate(), this.evento.getStartHour());
            EventScreen es = new EventScreen(this.evento, 1);
            es.setLocationRelativeTo(null);
            es.setVisible(true);
       } else {
            JOptionPane.showMessageDialog(null, "Nenhum evento foi selecionado.", "Aviso", JOptionPane.WARNING_MESSAGE);
       }
       
        
    }//GEN-LAST:event_btnEditEventActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuyTickets;
    private javax.swing.JButton btnCreateNewEvent;
    private javax.swing.JButton btnEditEvent;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaEventos;
    // End of variables declaration//GEN-END:variables
}
