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
}
