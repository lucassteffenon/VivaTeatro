/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.ticketmasterplus.businessDAO;

import br.univates.ticketmasterplus.business.Event;
import java.sql.Date;
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
public class ticketMasterPlusDAO {
      
    public void buyTicket(int idSeat, int idEvent, int idPerson, String status, int valor ){
        
    }
    
    public ArrayList<Event> getEventsList(){
        ArrayList<Event> events = new ArrayList();
        LocalDate dataExecucao = LocalDate.now();
        LocalTime horaExecucao = LocalTime.now();
        String sql = "SELECT * FROM Event WHERE startdate >= " + dataExecucao + " AND starthour >= " + horaExecucao;
        try (DataBaseConnectionManager db = new DataBaseConnectionManager(1, "facil", "postgres", "postgres")){
        
        
            
            
        } catch (DataBaseException ex) {
            Logger.getLogger(ticketMasterPlusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return events;
    }
    
public void createNewEvent(Event evento) {
    try (DataBaseConnectionManager db = new DataBaseConnectionManager(1, "facil", "postgres", "postgres")){
        db.connectDataBase();      
        String eventDescription = evento.getDescription();
        String eventName = evento.getName();
        String startDate = evento.getStartDate().replace("/", "-");
        String startHour = evento.getStartHour();
        String endDate = evento.getEndDate().replace("/", "-");
        String endHour = evento.getEndHour();
        int numberSeats = evento.getSeatsNumber();
        int basePrice = evento.getBasePrice();
        
        String values = "('" + eventDescription + "', '" + eventName + "', '" + startDate + "', '" + startHour + "', '" + endDate + "', '" + endHour + "', '" + numberSeats + "', '" + basePrice + "' )";
        String sql = "INSERT INTO Event (eventDescription, eventName, startDate, startHour, endDate, endHour, numberSeats, basePrice) VALUES " + values + "";
        
        db.executeSQL(sql);
        //db.executePreparedSQL(sql, eventDescription, eventName, startDate, startHour, endDate, endHour, numberSeats, basePrice);
        
        
    } catch (DataBaseException | DateTimeParseException ex) {
        Logger.getLogger(ticketMasterPlusDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
    public void editEvent(){
        
    }
    
    public void createNewUser(){
        
    }
    
    public void editUser(){
        
    }
    
    public void createNewSeat(){
        
    }
    
    public void editSeat(){
        
    }
    
}
