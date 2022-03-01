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
import model.Product;
import model.ProductType;

/**
 *
 * @author haili
 */
public class ProductDBContext extends DBContext{
     private PreparedStatement ps;
    private ResultSet rs;
    ArrayList<Product> pro = new ArrayList<Product>();
    
    public ArrayList<Product> getAll() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "select * from Product";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductType producType = new ProductType();
                producType = new ProductTypeDBContext().getOne(rs.getInt(4));
                Product pro = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        producType,
                        rs.getInt(5),
                        rs.getString(6), rs.getBoolean(7));
                list.add(pro);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
