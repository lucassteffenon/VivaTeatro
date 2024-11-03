/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.univates.ticketmasterplus.presentationGUI;

import br.univates.ticketmasterplus.business.Event;
import br.univates.ticketmasterplus.businessDAO.TicketMasterPlusDAO;
import br.univates.ticketmasterplus.util.InvalidEntryException;
import java.awt.Color;
import javax.management.StringValueExp;

/**
 *
 * @author lucassteffenon
 */
public class EventScreen extends javax.swing.JFrame {

    
    
    final public static int CREATE = 0;
    final public static int UPDATE = 1;
    
    private int CrudCode;
    private Event event = new Event();
    
    
    public EventScreen(Event evento, int CrudCode) {
        initComponents();
        this.btnCreate.setBackground(Color.red);
        this.CrudCode = CrudCode;
        if (CrudCode == 1) {
            setEvent(evento);
            setScreen(CrudCode);
        }
        
    }
    
    public void setEvent(Event evento){
        
        this.TextFieldEventName.setText(evento.getName());
        this.TextFieldStartDate.setText(evento.getStartDateFormatada());
        this.TextFieldStartHour.setText(evento.getStartHour());
        this.TextFieldEndDate.setText(evento.getEndDateFormatada());
        this.TextFieldEndHour.setText(evento.getEndHour());
        this.TextFieldNumberOfSeats.setText(String.valueOf(evento.getSeatsNumber()));
        this.TextFieldBasePrice.setText(String.valueOf(evento.getBasePrice()));
        this.TextEventDescription.setText(evento.getDescription());
        
        this.event.setIdEvent(evento.getIdEvent());
        this.event.setName(evento.getName());
        this.event.setDescription(evento.getDescription());
        this.event.setStartDate(evento.getStartDate());
        this.event.setStartHour(evento.getStartHour());
        this.event.setEndDate(evento.getEndDate());
        this.event.setEndHour(evento.getEndHour());
        this.event.setSeatsNumber(evento.getSeatsNumber());
        this.event.setBasePrice(evento.getBasePrice());
        
    }
    
    private void setScreen(int crudCode){
        if (this.CrudCode == CREATE) {
            this.title.setText("Create new Event");
            this.btnCreate.setText("Create");
        }
        if (this.CrudCode == UPDATE){
            this.title.setText("Update Event");
            this.btnCreate.setText("Update");
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        LabelEventName = new javax.swing.JLabel();
        LabelStartDate = new javax.swing.JLabel();
        LabelStartHour = new javax.swing.JLabel();
        LabelEndDate = new javax.swing.JLabel();
        LabelEndHour = new javax.swing.JLabel();
        LabelNumerSeats = new javax.swing.JLabel();
        LabelBasePrice = new javax.swing.JLabel();
        TextFieldEventName = new javax.swing.JTextField();
        TextFieldStartDate = new javax.swing.JTextField();
        TextFieldStartHour = new javax.swing.JTextField();
        TextFieldEndDate = new javax.swing.JTextField();
        TextFieldEndHour = new javax.swing.JTextField();
        TextFieldNumberOfSeats = new javax.swing.JTextField();
        TextFieldBasePrice = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextEventDescription = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        title.setText("Create New Event");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                .addGap(186, 186, 186))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(title)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        btnCreate.setBackground(new java.awt.Color(0, 153, 0));
        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(255, 204, 153));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        LabelEventName.setText("Event Name:");

        LabelStartDate.setText("Start Date:");

        LabelStartHour.setText("Start Hour:");

        LabelEndDate.setText("End Date:");

        LabelEndHour.setText("End Hour:");

        LabelNumerSeats.setText("Number of Seats:");

        LabelBasePrice.setText("Base Price:");

        TextFieldEventName.setText("insert the name of the event here...");
        TextFieldEventName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextFieldEventNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TextFieldEventNameFocusLost(evt);
            }
        });

        TextFieldStartDate.setText("insert here when the event will start, ex: 31/12/2024");
        TextFieldStartDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TextFieldStartDateFocusLost(evt);
            }
        });
        TextFieldStartDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldStartDateActionPerformed(evt);
            }
        });

        TextFieldStartHour.setText("insert here what hour the event will start, ex: 13:00");
        TextFieldStartHour.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TextFieldStartHourFocusLost(evt);
            }
        });

        TextFieldEndDate.setText("insert here when the event will end, ex: 31/12/2024");
        TextFieldEndDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TextFieldEndDateFocusLost(evt);
            }
        });

        TextFieldEndHour.setText("insert here what hour the event will end, ex: 15:00");
        TextFieldEndHour.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TextFieldEndHourFocusLost(evt);
            }
        });

        TextFieldNumberOfSeats.setText("insert here the maximun seats of the event.");
        TextFieldNumberOfSeats.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TextFieldNumberOfSeatsFocusLost(evt);
            }
        });

        TextFieldBasePrice.setText("insert here the price of the event");
        TextFieldBasePrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TextFieldBasePriceFocusLost(evt);
            }
        });

        TextEventDescription.setColumns(20);
        TextEventDescription.setRows(5);
        TextEventDescription.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TextEventDescriptionFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(TextEventDescription);

        jLabel2.setText("Event Description:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCreate))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelEventName)
                                    .addComponent(LabelStartDate)
                                    .addComponent(LabelStartHour)
                                    .addComponent(LabelEndDate)
                                    .addComponent(LabelEndHour))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextFieldEndHour, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TextFieldEventName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TextFieldStartDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TextFieldStartHour, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TextFieldEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelNumerSeats)
                                    .addComponent(LabelBasePrice))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextFieldNumberOfSeats)
                                    .addComponent(TextFieldBasePrice))))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelEventName)
                    .addComponent(TextFieldEventName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelStartDate)
                    .addComponent(TextFieldStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelStartHour)
                    .addComponent(TextFieldStartHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelEndDate)
                    .addComponent(TextFieldEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelEndHour)
                    .addComponent(TextFieldEndHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelNumerSeats)
                    .addComponent(TextFieldNumberOfSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelBasePrice)
                    .addComponent(TextFieldBasePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(btnBack))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed

        if (this.CrudCode == CREATE) {
            TicketMasterPlusDAO dao = new TicketMasterPlusDAO();
            dao.createNewEvent(this.event);
            dispose();
        }
        if (this.CrudCode == UPDATE) {
            TicketMasterPlusDAO dao = new TicketMasterPlusDAO();
            dao.editEvent(this.event);
            dispose();
        }
        

    }//GEN-LAST:event_btnCreateActionPerformed

    private void TextFieldStartDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldStartDateActionPerformed
        
    }//GEN-LAST:event_TextFieldStartDateActionPerformed

    private void TextFieldEventNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextFieldEventNameFocusLost

        if (TextFieldEventName.getText().isEmpty()) {
            TextFieldEventName.setText("insert the name of the event here...");
        } else {
            this.event.setName(TextFieldEventName.getText());
        }
        
        

    }//GEN-LAST:event_TextFieldEventNameFocusLost

    private void TextFieldStartDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextFieldStartDateFocusLost

        String startDate = TextFieldStartDate.getText().replaceAll("[^0-9]", "");
        String dd = startDate.substring(0, 2);
        String mm = startDate.substring(2, 4);
        String yyyy = startDate.substring(4, 8);
        String dataAmericana = yyyy + mm + dd;
        this.event.setStartDate(dataAmericana);
        
    }//GEN-LAST:event_TextFieldStartDateFocusLost

    private void TextFieldStartHourFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextFieldStartHourFocusLost
       
        this.event.setStartHour(TextFieldStartHour.getText());
        
    }//GEN-LAST:event_TextFieldStartHourFocusLost

    private void TextFieldEndDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextFieldEndDateFocusLost

        String endDate = TextFieldEndDate.getText().replaceAll("[^0-9]", "");
        String dd = endDate.substring(0, 2);
        String mm = endDate.substring(2, 4);
        String yyyy = endDate.substring(4, 8);
        String dataAmericana = yyyy + mm + dd;
        this.event.setEndDate(dataAmericana);

    }//GEN-LAST:event_TextFieldEndDateFocusLost

    private void TextFieldEndHourFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextFieldEndHourFocusLost

        this.event.setEndHour(TextFieldEndHour.getText());

    }//GEN-LAST:event_TextFieldEndHourFocusLost

    private void TextFieldNumberOfSeatsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextFieldNumberOfSeatsFocusLost

        this.event.setSeatsNumber(Integer.parseInt(TextFieldNumberOfSeats.getText()));

    }//GEN-LAST:event_TextFieldNumberOfSeatsFocusLost

    private void TextFieldBasePriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextFieldBasePriceFocusLost

        this.event.setBasePrice(Integer.parseInt(TextFieldBasePrice.getText()));

    }//GEN-LAST:event_TextFieldBasePriceFocusLost

    private void TextFieldEventNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextFieldEventNameFocusGained

        if(TextFieldEventName.getText().equalsIgnoreCase("insert the name of the event here...")){
            TextFieldEventName.setText("");
        }

    }//GEN-LAST:event_TextFieldEventNameFocusGained

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        dispose();
        
    }//GEN-LAST:event_btnBackActionPerformed

    private void TextEventDescriptionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextEventDescriptionFocusLost

        this.event.setDescription(TextEventDescription.getText());
        // TODO add your handling code here:
    }//GEN-LAST:event_TextEventDescriptionFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelBasePrice;
    private javax.swing.JLabel LabelEndDate;
    private javax.swing.JLabel LabelEndHour;
    private javax.swing.JLabel LabelEventName;
    private javax.swing.JLabel LabelNumerSeats;
    private javax.swing.JLabel LabelStartDate;
    private javax.swing.JLabel LabelStartHour;
    private javax.swing.JTextArea TextEventDescription;
    private javax.swing.JTextField TextFieldBasePrice;
    private javax.swing.JTextField TextFieldEndDate;
    private javax.swing.JTextField TextFieldEndHour;
    private javax.swing.JTextField TextFieldEventName;
    private javax.swing.JTextField TextFieldNumberOfSeats;
    private javax.swing.JTextField TextFieldStartDate;
    private javax.swing.JTextField TextFieldStartHour;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
