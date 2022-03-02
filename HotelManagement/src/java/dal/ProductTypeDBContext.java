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
import model.ProductType;
import model.Room;
import model.RoomType;

/**
 *
 * @author haili
 */
public class ProductTypeDBContext extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    public ArrayList<ProductType> getAll() {
        ArrayList<ProductType> list = new ArrayList<>();
        try {
            String sql = "select * from Product_Type";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductType pt = new ProductType(rs.getInt(1), rs.getString(2));
                list.add(pt);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProductTypeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ProductType getOne(int ProType) {
        try {
            String sql = "select * from Product_Type where ID=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, ProType);
            rs = ps.executeQuery();

            while (rs.next()) {
                ProductType pt = new ProductType(rs.getInt(1), rs.getString(2));
                return pt;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductTypeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<ProductType> search(String text_search) {
        ArrayList<ProductType> list = new ArrayList<>();
        try {
            String sql = "select * from Product_Type where ProductTypeName like '%" + text_search + "%'";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductType pt = new ProductType(rs.getInt(1), rs.getString(2));
                list.add(pt);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProductTypeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void update(ProductType pt) {
        try {
            String sql = "UPDATE [dbo].[Product_Type]\n"
                    + "   SET [ProductTypeName] =?\n"
                    + " WHERE ID = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, pt.getProductTypeName());
            ps.setInt(2, pt.getID());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductTypeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insert(ProductType pt) {
        try {
            String sql = "INSERT INTO [dbo].[Product_Type]\n"
                    + "           ([ProductTypeName])\n"
                    + "     VALUES\n"
                    + "           (?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, pt.getProductTypeName());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductTypeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int producttypeID) {
        try {
            String sql = "DELETE FROM [dbo].[Product_Type]\n"
                    + "      WHERE ID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, producttypeID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductTypeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
