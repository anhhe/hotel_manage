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
            String sql = "select * from Room";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                RoomType roomType = new RoomType();
                roomType.setID(rs.getInt(4));
                roomType = new RoomTypeDBContext().getOne(roomType);

                Room r = new Room(rs.getInt(1), rs.getString(2), rs.getBoolean(3), roomType);
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

                Room r = new Room(rs.getInt(1), rs.getString(2), rs.getBoolean(3), roomType);
                return r;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
