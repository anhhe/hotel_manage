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
import model.RoomType;

/**
 *
 * @author haili
 */
public class RoomTypeDBContext extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    public ArrayList<RoomType> getAll() {
        ArrayList<RoomType> list = new ArrayList<>();
        try {
            String sql = "select * from Room_Type";
            ps = connection.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                RoomType rt = new RoomType(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5));
                list.add(rt);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public RoomType getOne(RoomType roomType) {
        try {
            String sql = "select * from Room_Type where ID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, roomType.getID());
            rs = ps.executeQuery();
            while (rs.next()) {
                RoomType rt = new RoomType(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5));
                return rt;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insert(RoomType rt) {
        try {
            String sql = "INSERT INTO [dbo].[Room_Type]\n"
                    + "           ([RoomType]\n"
                    + "           ,[Price]\n"
                    + "           ,[NumberOfPeople]\n"
                    + "           ,[description])\n"
                    + "     VALUES\n"
                    + "           (?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, rt.getRoomTypeName());
            ps.setDouble(2, rt.getPrice());
            ps.setInt(3, rt.getNumberOfPeople());
            ps.setString(4, rt.getDescription());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int roomtypeID) {
        try {
            String sql = "DELETE FROM [dbo].[Room_Type]\n"
                    + "      WHERE ID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, roomtypeID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(RoomType rt) {
        try {
            String sql = "UPDATE [dbo].[Room_Type]\n"
                    + "   SET [RoomType] = ?\n"
                    + "      ,[Price] = ?\n"
                    + "      ,[NumberOfPeople] = ?\n"
                    + "      ,[description] = ?\n"
                    + " WHERE ID = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, rt.getRoomTypeName());
            ps.setDouble(2, rt.getPrice());
            ps.setInt(3, rt.getNumberOfPeople());
            ps.setString(4, rt.getDescription());
            ps.setInt(5, rt.getID());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<RoomType> search(String text_search) {
        ArrayList<RoomType> list = new ArrayList<>();
        try {
            String sql = "select * from Room_Type where RoomType like '%"+text_search+"%'";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                RoomType rt = new RoomType(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5));
                list.add(rt);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
