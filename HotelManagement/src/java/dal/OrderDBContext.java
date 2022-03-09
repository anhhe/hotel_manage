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
import model.Booking;
import model.Order;
import model.Payment;
import model.Product;

/**
 *
 * @author Duc Anh
 */
public class OrderDBContext extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    public int insert(Order order) {
        try {
            String sql = "INSERT INTO [dbo].[Order]\n"
                    + "           ([ProductID]\n"
                    + "           ,[BookingID]\n"
                    + "           ,[OrderDate]\n"
                    + "           ,[quantity]\n"
                    + "           ,[price])\n"
                    + "     VALUES\n"
                    + "           (?, ?, ?, ?, ?)";
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getProduct().getID());
            ps.setInt(2, order.getBooking().getID());
            ps.setDate(3, order.getDate());
            ps.setInt(4, order.getQuantity());
            ps.setDouble(5, order.getPrice());
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

    public Order getOne(int orderID) {
        try {
            String sql = "  select * from [Order] where ID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, orderID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product = new ProductDBContext().getOne(rs.getInt(2));

                Booking booking = new BookingDBContext().getOne(rs.getInt(3));
                Order o = new Order(rs.getInt(1), product, booking, rs.getDate(4), rs.getInt(5), rs.getDouble(6));
                return o;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Order> getListByPayment(Payment payment) {
        ArrayList<Order> list = new ArrayList<>();
        try {
            String sql = "  select [Order].* from Payment inner join Booking on Payment.BookingID = Booking.ID\n"
                    + "inner join [Order] on Booking.ID = [Order].BookingID\n"
                    + "where CustomerID = ? and Booking.ID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, payment.getBooking().getCustomer().getId());
            ps.setInt(2, payment.getBooking().getID());
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product = new ProductDBContext().getOne(rs.getInt(2));

                Booking booking = new BookingDBContext().getOne(rs.getInt(3));
                Order o = new Order(rs.getInt(1), product, booking, rs.getDate(4), rs.getInt(5), rs.getDouble(6));

                list.add(o);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        ArrayList<Order> list = new ArrayList<>();
        Payment payment = new Payment();

        payment = new PaymentDBContext().getOne(1);
        list = new OrderDBContext().getListByPayment(payment);
        for (Object object : list) {
            System.out.println(object);
        }
    }

    public void delete(int id) {
        try {
            String sql = "DELETE FROM [dbo].[Order]\n"
                    + "      WHERE BookingID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
