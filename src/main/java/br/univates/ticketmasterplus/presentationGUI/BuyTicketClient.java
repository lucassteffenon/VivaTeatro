/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.univates.ticketmasterplus.presentationGUI;

import br.univates.ticketmasterplus.business.Event;
import br.univates.ticketmasterplus.business.Person;
import br.univates.ticketmasterplus.business.Seat;
import br.univates.ticketmasterplus.business.SeatReservation;
import br.univates.ticketmasterplus.business.User;
import br.univates.ticketmasterplus.businessDAO.VivaTeatroDAO;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;

public class BuyTicketClient extends javax.swing.JFrame {
    
    private Event evento;
    private SeatReservation seatReservation;
    private Person person = new Person();
    private Seat seat;
    
    public BuyTicketClient(SeatReservation seatR, Event evento, Seat seat) {
        initComponents();
        this.seatReservation = seatR;
        this.evento = evento;
        this.seat = seat;
        this.alterTexts();
    }
    
    private void alterTexts(){
        labelEventName.setText(this.evento.getName());
        labelSeatName.setText(this.seat.getDescription());
        labelPrice.setText(String.valueOf(this.seatReservation.getPrice()));
    }
    
    public static void gerarIngressoPDF(String nomeArquivo, String nomeEvento, String dataEvento, String horaInicio, String horaFim, String localEvento, String comprador, String assento, String valorIngresso) {
        Document documento = new Document();
        try {
            PdfWriter.getInstance(documento, new FileOutputStream(nomeArquivo));
            documento.open();

            // Cabeçalho do ingresso
            Font fonteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Paragraph titulo = new Paragraph("Ingresso para " + nomeEvento, fonteTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);
            documento.add(new Paragraph("\n"));

            // Tabela com as informações do evento e comprador
            PdfPTable tabela = new PdfPTable(2);
            tabela.setWidthPercentage(100);
            tabela.setSpacingBefore(10f);
            tabela.setSpacingAfter(10f);

            adicionarCelulaTabela(tabela, "Evento:", nomeEvento);
            adicionarCelulaTabela(tabela, "Data:", dataEvento);
            adicionarCelulaTabela(tabela, "Hora de Início:", horaInicio);
            adicionarCelulaTabela(tabela, "Hora de Fim:", horaFim);
            adicionarCelulaTabela(tabela, "Local:", localEvento);
            adicionarCelulaTabela(tabela, "Comprador:", comprador);
            adicionarCelulaTabela(tabela, "Assento:", assento);
            adicionarCelulaTabela(tabela, "Valor do Ingresso: R$", valorIngresso);

            documento.add(tabela);

            // Rodapé
            Font fonteRodape = FontFactory.getFont(FontFactory.HELVETICA, 10);
            Paragraph rodape = new Paragraph("Obrigado por adquirir o ingresso!", fonteRodape);
            rodape.setAlignment(Element.ALIGN_CENTER);
            documento.add(rodape);

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } finally {
            documento.close();
        }
    }

    private static void adicionarCelulaTabela(PdfPTable tabela, String titulo, String valor) {
        Font fonteCelula = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
        PdfPCell celulaTitulo = new PdfPCell(new Paragraph(titulo, fonteCelula));
        celulaTitulo.setBorder(PdfPCell.NO_BORDER);
        tabela.addCell(celulaTitulo);

        Font fonteValor = FontFactory.getFont(FontFactory.HELVETICA, 12);
        PdfPCell celulaValor = new PdfPCell(new Paragraph(valor, fonteValor));
        celulaValor.setBorder(PdfPCell.NO_BORDER);
        tabela.addCell(celulaValor);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnConfirm = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDoc = new javax.swing.JTextField();
        jName = new javax.swing.JTextField();
        jEmail = new javax.swing.JTextField();
        jPhone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labelEventName = new javax.swing.JLabel();
        labelSeatName = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        labelPrice = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel1.setText("Passport:");

        jLabel2.setText("Name:");

        jLabel3.setText("Email:");

        jLabel4.setText("Phone:");

        jDoc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jDocFocusLost(evt);
            }
        });

        jName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jNameFocusLost(evt);
            }
        });

        jEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jEmailFocusLost(evt);
            }
        });

        jPhone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPhoneFocusLost(evt);
            }
        });

        jLabel6.setText("Seat:");

        jLabel7.setText("Event:");

        labelEventName.setText("eventNameHere");

        labelSeatName.setText("seatNameHere");

        jLabel10.setText("Price:");

        labelPrice.setText("priceHere");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))
                        .addGap(0, 299, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(btnCancel))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jDoc)
                                    .addComponent(jName)
                                    .addComponent(jEmail)
                                    .addComponent(jPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelPrice)
                                    .addComponent(labelSeatName)
                                    .addComponent(labelEventName))
                                .addGap(0, 190, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnConfirm)
                                .addGap(29, 29, 29))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1)
                                            .addComponent(jDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2))
                                    .addComponent(jName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addComponent(jEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addComponent(jPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(labelEventName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(labelSeatName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(labelPrice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirm)
                    .addComponent(btnCancel))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jDocFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jDocFocusLost
        String doc = jDoc.getText();
        if(doc != null && doc.length() <= 9 && doc.length() > 0){
            this.person.setDoc(doc);
            VivaTeatroDAO dao = new VivaTeatroDAO();
            Person p = dao.getPerson(doc);
            if (p != null) {
                if (dao.isValidToBuy(doc, this.evento.getIdEvent())) {
                    this.jDoc.disable();
                    this.person = p;
                    this.jName.setText(this.person.getNome());
                    this.jEmail.setText(this.person.getEmail());
                    this.jPhone.setText(this.person.getFone());
                } else {
                    JOptionPane.showMessageDialog(null, "This person has already bought a seat", "Warning", JOptionPane.WARNING_MESSAGE);
                }  
            }
        }
        
    }//GEN-LAST:event_jDocFocusLost

    private void jNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jNameFocusLost
        String name = jName.getText();
        if (name != null){
            this.person.setNome(name);
        }
    }//GEN-LAST:event_jNameFocusLost

    private void jEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jEmailFocusLost
        String email = jEmail.getText();
        if (email != null && email.contains("@")) {
            this.person.setEmail(email);
        }
        
        
    }//GEN-LAST:event_jEmailFocusLost

    private void jPhoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPhoneFocusLost
        String phone = jPhone.getText();
        if (phone != null) {
            this.person.setFone(phone);
        }
    }//GEN-LAST:event_jPhoneFocusLost

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
        
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        if (this.person.getDoc() != "" && this.person.getNome() != "" && this.person.getEmail() != "" && this.person.getFone() != "") {
            VivaTeatroDAO dao = new VivaTeatroDAO();
            dao.createNewPerson(this.person.getDoc(), "passport", this.person.getNome(), this.person.getFone(), this.person.getEmail());
            dao.buyTicket(this.seatReservation.getIdSeat(), this.seatReservation.getIdEvent(), this.person.getDoc(), "vendido");
            String nomeArquivo = "" + String.valueOf(this.evento.getIdEvent()) + "" + String.valueOf(this.seatReservation.getIdSeatReservation()) + ".pdf";
            gerarIngressoPDF(nomeArquivo, this.evento.getName(), this.evento.getStartDateFormatada(), this.evento.getStartHour(), this.evento.getEndHour(), "Boa Vista do Sul", this.person.getNome(), this.seat.getDescription(), String.valueOf(this.seatReservation.getPrice()));
        }
        dispose();
    }//GEN-LAST:event_btnConfirmActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JTextField jDoc;
    private javax.swing.JTextField jEmail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jName;
    private javax.swing.JTextField jPhone;
    private javax.swing.JLabel labelEventName;
    private javax.swing.JLabel labelPrice;
    private javax.swing.JLabel labelSeatName;
    // End of variables declaration//GEN-END:variables
}
