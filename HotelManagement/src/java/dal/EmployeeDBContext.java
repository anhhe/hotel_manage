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
import model.Employee;
import model.EmployeeType;

/**
 *
 * @author haili
 */
public class EmployeeDBContext extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    public ArrayList<Employee> getAll() {
        ArrayList<Employee> list = new ArrayList<>();
        try {
            String sql = "select * from Employee";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                EmployeeType employeeType = new EmployeeType();
                employeeType = new EmployeeTypeDBContext().getOne(rs.getInt(2));

                Account account = new Account();
                account = new AccountDBContext().getAccountByID(rs.getInt(4));

                Employee e = new Employee(rs.getInt(1), employeeType,
                        rs.getBoolean(3), account, rs.getString(5), rs.getBoolean(6), rs.getString(7), rs.getString(8));

                list.add(e);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int getTotal() {
        int total = 0;
        try {
            String sql = "select count(*) from Employee";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public static void main(String[] args) {
        int total = new EmployeeDBContext().getTotal();
        System.out.println(total);
    }
}
