/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.ticketmasterplus.business;

/**
 *
 * @author lucassteffenon
 */
public class SeatReservation {
    
    private int idSeatReservation;
    private int idSeat;
    private int idEvent;
    private String docperson;
    private int idUser;
    private String status;
    private double price;
    
    public SeatReservation(int idseatR, int idS, int idE, String docP, int idU, String s, double p){
        this.idSeatReservation = idseatR;
        this.idSeat = idS;
        this.idEvent = idE;
        this.docperson = docP;
        this.idUser = idU;
        this.status = s;
        this.price = p;
    }
    
    public SeatReservation(){
        
    }

    public int getIdSeatReservation() {
        return idSeatReservation;
    }

    public void setIdSeatReservation(int idSeatReservation) {
        this.idSeatReservation = idSeatReservation;
    }

    public int getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(int idSeat) {
        this.idSeat = idSeat;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public String getDocPerson() {
        return docperson;
    }

    public void setDocPerson(String docPerson) {
        this.docperson = docPerson;
    }
    
    public int getIdUser(){
        return idUser;
    }
    
    public void setIdUser(int idUser){
        this.idUser = idUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
}
