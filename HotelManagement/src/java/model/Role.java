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
public class Role {

    private int ID;
    private String roleName;

    public Role() {
    }

    public Role(int ID, String roleName) {
        this.ID = ID;
        this.roleName = roleName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" + "ID=" + ID + ", roleName=" + roleName + '}';
    }

}
