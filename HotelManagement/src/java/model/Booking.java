/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Duc Anh
 */
public class Booking {
    private int ID;
    private Customer customer;
    private Room room;
    private Date checkIn;
    private Date checkOut;
    private boolean status;

    public Booking() {
    }


    
}
