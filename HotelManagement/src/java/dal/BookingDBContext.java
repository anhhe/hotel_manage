/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class BookingDBContext extends DBContext {

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

                Booking b = new Booking(rs.getInt(1), customer, room, rs.getDate(4), rs.getDate(5), rs.getBoolean(6));
                return b;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int insert(Booking booking) {
        try {
            String sql = "INSERT INTO [dbo].[Booking]\n"
                    + "           ([CustomerID]\n"
                    + "           ,[RoomID]\n"
                    + "           ,[CheckIn]\n"
                    + "           ,[CheckOut]\n"
                    + "           ,[status])\n"
                    + "     VALUES\n"
                    + "           (?, ?, ?, ?, ?)";
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, booking.getCustomer().getId());
            ps.setInt(2, booking.getRoom().getID());
            ps.setDate(3, booking.getCheckIn());
            ps.setDate(4, booking.getCheckOut());
            ps.setBoolean(5, booking.isStatus());
            ps.execute();
            rs = ps.getGeneratedKeys();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static void main(String[] args) {
        Booking booking = new BookingDBContext().getOne(1);
        int id = new BookingDBContext().insert(booking);
        System.out.println(id);
    }

    public void delete(int id) {
        try {
            String sql = "DELETE FROM [dbo].[Booking]\n"
                    + "      WHERE ID = ?";
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
