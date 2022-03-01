/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Time;

/**
 *
 * @author Duc Anh
 */
public class Booking {
    private int ID;
    private Customer customer;
    private Room room;
    private Time checkIn;
    private Time checkOut;
    private boolean status;

    public Booking() {
    }

    public Booking(int ID, Customer customer, Room room, Time checkIn, Time checkOut, boolean status) {
        this.ID = ID;
        this.customer = customer;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Time getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Time checkIn) {
        this.checkIn = checkIn;
    }

    public Time getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Time checkOut) {
        this.checkOut = checkOut;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Booking{" + "ID=" + ID + ", customer=" + customer + ", room=" + room + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", status=" + status + '}';
    }
    
    
}
