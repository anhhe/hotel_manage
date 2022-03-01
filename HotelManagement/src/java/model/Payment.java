/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Duc Anh
 */
public class Payment {

    private int ID;
    private Booking booking;
    private double amount;
    private Date date;
    private String note;
    private boolean status;

    public Payment() {
    }

    public Payment(int ID, Booking booking, double amount, Date date, String note, boolean status) {
        this.ID = ID;
        this.booking = booking;
        this.amount = amount;
        this.date = date;
        this.note = note;
        this.status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Payment{" + "ID=" + ID + ", booking=" + booking + ", amount=" + amount + ", date=" + date + ", note=" + note + ", status=" + status + '}';
    }

}
