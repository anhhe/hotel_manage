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
public class RoomType {

    private int ID;
    private String roomTypeName;
    private double price;
    private int numberOfPeople;
    private String description;

    public RoomType() {
    }

    public RoomType(String roomTypeName, double price, int numberOfPeople, String description) {
        this.roomTypeName = roomTypeName;
        this.price = price;
        this.numberOfPeople = numberOfPeople;
        this.description = description;
    }

    public RoomType(int ID, String roomTypeName, double price, int numberOfPeople, String description) {
        this.ID = ID;
        this.roomTypeName = roomTypeName;
        this.price = price;
        this.numberOfPeople = numberOfPeople;
        this.description = description;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "RoomType{" + "ID=" + ID + ", roomTypeName=" + roomTypeName + ", price=" + price + ", numberOfPeople=" + numberOfPeople + ", description=" + description + '}';
    }

}
