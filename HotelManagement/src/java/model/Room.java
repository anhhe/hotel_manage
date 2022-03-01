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
public class Room {

    private int ID;
    private String roomName;
    private boolean status;
    private RoomType roomType;

    public Room() {
    }

    public Room(String roomName, boolean status, RoomType roomType) {
        this.roomName = roomName;
        this.status = status;
        this.roomType = roomType;
    }

    public Room(int ID, String roomName, boolean status, RoomType roomType) {
        this.ID = ID;
        this.roomName = roomName;
        this.status = status;
        this.roomType = roomType;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return "Room{" + "ID=" + ID + ", roomName=" + roomName + ", status=" + status + ", roomType=" + roomType + '}';
    }

}
