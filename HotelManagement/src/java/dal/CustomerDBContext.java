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
import model.Customer;
import model.Room;

/**
 *
 * @author Duc Anh
 */
public class CustomerDBContext extends DBContext {

    PreparedStatement ps;
    ResultSet rs;
    ArrayList<Customer> cus = new ArrayList<>();

    public ArrayList<Customer> getAll() {
        try {
            String sql = "select * from Customer";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Account acc = new Account();
                acc = new AccountDBContext().getAccountByID(rs.getInt(9));
                Customer customer = new Customer(rs.getInt(1),
                        rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5),
                        rs.getBoolean(6), rs.getString(7), rs.getBoolean(8), acc);
                cus.add(customer);
            }
            return cus;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Customer getOne(int aInt) {
        try {
            String sql = "select * from Customer where ID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, aInt);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account acc = new Account();
                acc = new AccountDBContext().getAccountByID(rs.getInt(9));

                Customer customer = new Customer(rs.getInt(1),
                        rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5),
                        rs.getBoolean(6), rs.getString(7), rs.getBoolean(8), acc);
                return customer;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Customer getOneByAccountID(Account account) {
        try {
            String sql = "select * from Customer where accountID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, account.getID());
            rs = ps.executeQuery();
            while (rs.next()) {
                Account acc = new Account();
                acc = new AccountDBContext().getAccountByID(rs.getInt(9));

                Customer customer = new Customer(rs.getInt(1),
                        rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5),
                        rs.getBoolean(6), rs.getString(7), rs.getBoolean(8), acc);
                return customer;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
//    private int id;
//    private String phone;
//    private String email;
//    private String address;
//    private String IDProof;
//    private boolean gender;
//    private String image;
//    private boolean status;
//    private Account accountid;
