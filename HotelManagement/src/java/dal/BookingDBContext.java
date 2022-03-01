/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Booking;
import model.Customer;
import model.Payment;
import model.Room;

/**
 *
 * @author Duc Anh
 */
public class BookingDBContext extends DBContext{

    private PreparedStatement ps;
    private ResultSet rs;

    public Booking getOne(int aInt) {
        try {
            String sql = "select * from Booking where ID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, aInt);
            rs = ps.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer = new CustomerDBContext().getOne(rs.getInt(2));
                
                Room room = new Room();
                room = new RoomDBContext().getOne(rs.getInt(3));
                
                Booking b = new Booking(rs.getInt(1), customer, room, rs.getTime(4), rs.getTime(5), rs.getBoolean(6));
                return b;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
