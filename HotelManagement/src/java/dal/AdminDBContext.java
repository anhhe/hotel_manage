/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Admin;
import model.Employee;
import model.EmployeeType;

/**
 *
 * @author haili
 */
public class AdminDBContext extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;
    
    public Admin getOne(int id) {
        try {
            String sql = "select * from Admin where accountID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account accountID = new Account();
                accountID = new AccountDBContext().getAccountByID(rs.getInt(7));
                
                Admin a = new Admin(rs.getInt(1), rs.getString(2), rs.getBoolean(3), 
                        rs.getString(4), rs.getString(5), rs.getBoolean(6), accountID, rs.getString(8));
                
                return a;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
