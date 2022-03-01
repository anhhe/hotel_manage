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
import model.Account;
import model.Booking;
import model.Employee;
import model.EmployeeType;
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

}
