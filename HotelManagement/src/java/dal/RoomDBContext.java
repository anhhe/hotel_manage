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
import model.RoomType;

/**
 *
 * @author haili
 */
public class RoomDBContext extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    public ArrayList<Room> getAll() {
        ArrayList<Room> list = new ArrayList<>();
        try {
            String sql = "SELECT TOP (1000) [ID]\n"
                    + "      ,[RoomName]\n"
                    + "      ,[status]\n"
                    + "      ,[RoomTypeID]\n"
                    + "      ,[image]\n"
                    + "  FROM [HotelManagement].[dbo].[Room]";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                RoomType roomType = new RoomType();
                roomType.setID(rs.getInt(4));
                roomType = new RoomTypeDBContext().getOne(roomType);

                Room r = new Room(rs.getInt(1), rs.getString(2), rs.getBoolean(3), roomType, rs.getString(5));
                list.add(r);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        ArrayList<Room> list = new ArrayList<>();
        list = new RoomDBContext().getAll();
        for (Room r : list) {
            System.out.println(r);
        }
    }

    public int getTotal() {
        int total = 0;
        try {
            String sql = "select count(*) from Room";
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

    public Room getOne(int aInt) {
        try {
            String sql = "select * from Room where ID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, aInt);
            rs = ps.executeQuery();
            while (rs.next()) {
                RoomType roomType = new RoomType();
                roomType.setID(rs.getInt(4));
                roomType = new RoomTypeDBContext().getOne(roomType);

                Room r = new Room(rs.getInt(1), rs.getString(2), rs.getBoolean(3), roomType, rs.getString(5));
                return r;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void delete(int roomID) {
        try {
            String sql = "DELETE FROM [dbo].[Room]\n"
                    + "      WHERE ID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, roomID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Room room) {
        try {
            String sql = "UPDATE [dbo].[Room]\n"
                    + "   SET [RoomName] = ?\n"
                    + "      ,[status] = ?\n"
                    + "      ,[RoomTypeID] = ?\n"
                    + " WHERE ID = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, room.getRoomName());
            ps.setBoolean(2, room.isStatus());
            ps.setInt(3, room.getRoomType().getID());
            ps.setInt(4, room.getID());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Room> search(String text_search) {
        ArrayList<Room> list = new ArrayList<>();
        try {
            String sql = "select * from Room where RoomName like '%" + text_search + "%'";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                RoomType roomType = new RoomType();
                roomType.setID(rs.getInt(4));
                roomType = new RoomTypeDBContext().getOne(roomType);

                Room r = new Room(rs.getInt(1), rs.getString(2), rs.getBoolean(3), roomType, rs.getString(5));
                list.add(r);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insert(Room room) {
        try {
            String sql = "INSERT INTO [dbo].[Room]\n"
                    + "           ([RoomName]\n"
                    + "           ,[status]\n"
                    + "           ,[RoomTypeID])\n"
                    + "     VALUES\n"
                    + "           (?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, room.getRoomName());
            ps.setBoolean(2, room.isStatus());
            ps.setInt(3, room.getRoomType().getID());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
