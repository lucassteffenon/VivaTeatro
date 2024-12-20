/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.ticketmasterplus.business;

/**
 *
 * @author lucassteffenon
 */
public class Event {

    private int idEvent;
    private String name;
    private String description;
    private String startDate;
    private String startHour;
    private String endDate;
    private String endHour;
    private int seatsNumber;
    private int basePrice;
    
    public Event(){
        
    }

    public Event (int idEvent, String name, String description, String startDate, String startHour, String endDate, String endHour, int seatsNumber, int basePrice) {
        this.idEvent = idEvent;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.startHour = startHour;
        this.endDate = endDate;
        this.endHour = endHour;
        this.seatsNumber = seatsNumber;
        this.basePrice = basePrice;
    }
    
    public int getIdEvent(){
        return idEvent;
    }
    
    public void setIdEvent(int idEvent){
        this.idEvent = idEvent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }
    
    public String getStartDateFormatada(){
        String dd = startDate.substring(8, 10);
        String mm = startDate.substring(5,7);
        String aaaa = startDate.substring(0,4);
        return dd + "/" + mm + "/" + aaaa;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getEndDate() {
        return endDate;
    }
    
    public String getEndDateFormatada(){
        String dd = endDate.substring(8,10);
        String mm = endDate.substring(5,7);
        String aaaa = endDate.substring(0,4);
        return dd + "/" + mm + "/" + aaaa;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }
}
