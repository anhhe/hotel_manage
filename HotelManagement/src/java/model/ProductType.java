/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.logging.Logger;

/**
 *
 * @author haili
 */
public class ProductType {

    private int ID;
    private String productTypeName;

    public ProductType() {
    }

    public ProductType(int ID, String productTypeName) {
        this.ID = ID;
        this.productTypeName = productTypeName;
    }

    public ProductType(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    @Override
    public String toString() {
        return "ProductType{" + "ID=" + ID + ", productTypeName=" + productTypeName + '}';
    }

}
