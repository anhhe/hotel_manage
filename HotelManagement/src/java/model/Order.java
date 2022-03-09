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
public class Order {

    private int ID;
    private Product product;
    private Booking booking;
    private Date date;
    private int quantity;
    private double price;

    public Order() {
    }

    public Order(Product product, Booking booking, Date date, int quantity, double price) {
        this.product = product;
        this.booking = booking;
        this.date = date;
        this.quantity = quantity;
        this.price = price;
    }

    public Order(int ID, Product product, Booking booking, Date date, int quantity, double price) {
        this.ID = ID;
        this.product = product;
        this.booking = booking;
        this.date = date;
        this.quantity = quantity;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" + "ID=" + ID + ", product=" + product + ", booking=" + booking + ", date=" + date + ", quantity=" + quantity + ", price=" + price + '}';
    }

}
