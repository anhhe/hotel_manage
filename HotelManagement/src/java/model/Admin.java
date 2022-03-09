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
public class Admin {

    private int ID;
    private String image;
    private boolean gender;
    private String phone, email;
    private boolean status;
    private Account accountID;
    private String address;

    public Admin() {
    }

    public Admin(int ID, String image, boolean gender, String phone, String email, boolean status, Account accountID, String address) {
        this.ID = ID;
        this.image = image;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.accountID = accountID;
        this.address = address;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Account getAccountID() {
        return accountID;
    }

    public void setAccountID(Account accountID) {
        this.accountID = accountID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Admin{" + "ID=" + ID + ", image=" + image + ", gender=" + gender + ", phone=" + phone + ", email=" + email + ", status=" + status + ", accountID=" + accountID + ", address=" + address + '}';
    }

}
