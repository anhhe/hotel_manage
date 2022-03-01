/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author haili
 */
public class Product {

    private int ID;
    private String productName;
    private double cost;
    private ProductType producType;
    private int quantity;
    private String description;
    private boolean status;

    public Product() {
    }

    public Product(int ID, String productName, double cost, ProductType producType, int quantity, String description, boolean status) {
        this.ID = ID;
        this.productName = productName;
        this.cost = cost;
        this.producType = producType;
        this.quantity = quantity;
        this.description = description;
        this.status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public ProductType getProducType() {
        return producType;
    }

    public void setProducType(ProductType producType) {
        this.producType = producType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" + "ID=" + ID + ", productName=" + productName + ", cost=" + cost + ", producType=" + producType + ", quantity=" + quantity + ", description=" + description + ", status=" + status + '}';
    }

}
