/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Booking;
import model.Customer;
import model.Employee;
import model.EmployeeType;
import model.Order;
import model.Payment;

/**
 *
 * @author Duc Anh
 */
public class PaymentDBContext extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    public ArrayList<Payment> getAll() {
        ArrayList<Payment> list = new ArrayList<>();
        try {
            String sql = "select * from Payment";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Booking booking = new Booking();
                booking = new BookingDBContext().getOne(rs.getInt(2));

                Payment p = new Payment(rs.getInt(1), booking, rs.getDouble(3), rs.getDate(4), rs.getString(5), rs.getBoolean(6));
                list.add(p);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insert(Payment payment) {
        try {
            String sql = "INSERT INTO [dbo].[Payment]\n"
                    + "           ([BookingID]\n"
                    + "           ,[amount]\n"
                    + "           ,[PaymentDate]\n"
                    + "           ,[Note]\n"
                    + "           ,[status])\n"
                    + "     VALUES\n"
                    + "           (?, ?, ?, ?, ?)";
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, payment.getBooking().getID());
            ps.setDouble(2, payment.getAmount());
            ps.setDate(3, payment.getDate());
            ps.setString(4, payment.getNote());
            ps.setBoolean(5, payment.isStatus());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Payment> getListByCustomer(Customer customer) {
        ArrayList<Payment> list = new ArrayList<>();
        try {
            String sql = "select Payment.* from Customer\n"
                    + "inner join Booking on Customer.ID = Booking.CustomerID\n"
                    + "inner join Payment on Payment.BookingID = Booking.ID\n"
                    + "where Customer.ID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, customer.getId());
            rs = ps.executeQuery();
            while (rs.next()) {
                Booking booking = new Booking();
                booking = new BookingDBContext().getOne(rs.getInt(2));

                Payment p = new Payment(rs.getInt(1), booking, rs.getDouble(3), rs.getDate(4), rs.getString(5), rs.getBoolean(6));
                list.add(p);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        Payment payment = new PaymentDBContext().getOne(1);
        System.out.println(payment);
    }

    public Payment getOne(int paymentID) {
        try {
            String sql = "select * from Payment where ID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, paymentID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Booking booking = new Booking();
                booking = new BookingDBContext().getOne(rs.getInt(2));

                Payment p = new Payment(rs.getInt(1), booking, rs.getDouble(3), rs.getDate(4), rs.getString(5), rs.getBoolean(6));
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void delete(int paymentID) {
        try {
            String sql = "DELETE FROM [dbo].[Payment]\n"
                    + "      WHERE ID = ?";
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, paymentID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
