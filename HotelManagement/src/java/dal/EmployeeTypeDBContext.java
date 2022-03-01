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
import model.EmployeeType;
import model.Room;
import model.RoomType;

/**
 *
 * @author haili
 */
public class EmployeeTypeDBContext extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    public ArrayList<EmployeeType> getAll() {
        ArrayList<EmployeeType> list = new ArrayList<>();
        try {
            String sql = "select * from Employee_Type";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                EmployeeType et = new EmployeeType(rs.getInt(1), rs.getString(2));
                list.add(et);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public EmployeeType getOne(int aInt) {
        try {
            String sql = "select * from Employee_Type where ID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, aInt);
            rs = ps.executeQuery();
            while (rs.next()) {
                EmployeeType e = new EmployeeType(rs.getInt(1), rs.getString(2));
                return e;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
