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
public class Employee {

    private int ID;
    private EmployeeType employeeType;
    private boolean status;
    private Account account;
    private String image;
    private boolean gender;
    private String email;
    private String phone;

    public Employee() {
    }

    public Employee(int ID, EmployeeType employeeType, boolean status, Account account, String image, boolean gender, String email, String phone) {
        this.ID = ID;
        this.employeeType = employeeType;
        this.status = status;
        this.account = account;
        this.image = image;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Employee{" + "ID=" + ID + ", employeeType=" + employeeType + ", status=" + status + ", account=" + account + ", image=" + image + ", gender=" + gender + ", email=" + email + ", phone=" + phone + '}';
    }

}
