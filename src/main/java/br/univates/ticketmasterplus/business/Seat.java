package br.univates.ticketmasterplus.business;

public class Seat {

    private int id;
    private String description;
    private double multiplicator;
    private String status;
    private boolean specialPerson;
    private int posX;
    private int posY;

    public Seat(int id, String description, double multiplicator, String status, boolean specialPerson, int posX, int posY) {
        this.id = id;
        this.description = description;
        this.multiplicator = multiplicator;
        this.status = status;
        this.specialPerson = specialPerson;
        this.posX = posX;
        this.posY = posY;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMultiplicator() {
        return multiplicator;
    }

    public void setMultiplicator(double multiplicator) {
        this.multiplicator = multiplicator;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isSpecialPerson() {
        return specialPerson;
    }

    public void setSpecialPerson(boolean specialPerson) {
        this.specialPerson = specialPerson;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
