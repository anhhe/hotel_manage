/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Duc Anh
 */
public class Customer {

    private int id;
    private String phone;
    private String email;
    private String address;
    private String IDProof;
    private boolean gender;
    private String image;
    private boolean status;
    private Account accountid;

    public Customer() {
    }

    public Customer(int id, String phone, String email, String address, String IDProof, boolean gender, String image, boolean status, Account accountid) {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.IDProof = IDProof;
        this.gender = gender;
        this.image = image;
        this.status = status;
        this.accountid = accountid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIDProof() {
        return IDProof;
    }

    public void setIDProof(String IDProof) {
        this.IDProof = IDProof;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Account getAccountid() {
        return accountid;
    }

    public void setAccountid(Account accountid) {
        this.accountid = accountid;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", phone=" + phone + ", email=" + email + ", address=" + address + ", IDProof=" + IDProof + ", gender=" + gender + ", image=" + image + ", status=" + status + ", accountid=" + accountid + '}';
    }
    
    
            
}
