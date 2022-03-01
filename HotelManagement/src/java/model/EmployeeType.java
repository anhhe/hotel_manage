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
public class EmployeeType {

    private int ID;
    private String employeeTypeName;

    public EmployeeType() {
    }

    public EmployeeType(int ID, String employeeTypeName) {
        this.ID = ID;
        this.employeeTypeName = employeeTypeName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmployeeTypeName() {
        return employeeTypeName;
    }

    public void setEmployeeTypeName(String employeeTypeName) {
        this.employeeTypeName = employeeTypeName;
    }

    @Override
    public String toString() {
        return "EmployeeType{" + "ID=" + ID + ", employeeTypeName=" + employeeTypeName + '}';
    }

}
