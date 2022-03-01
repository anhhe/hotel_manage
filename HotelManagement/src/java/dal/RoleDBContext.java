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
import model.Role;

/**
 *
 * @author haili
 */
public class RoleDBContext extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    public Role getOne(Role role) {
        try {
            String sql = "Selct * from Role where ID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, role.getID());
            rs = ps.executeQuery();
            while (rs.next()) {
                Role r = new Role(rs.getInt(1), rs.getString(2));
                return r;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoleDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
