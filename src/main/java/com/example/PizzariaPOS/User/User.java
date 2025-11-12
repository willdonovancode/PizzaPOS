package com.example.PizzariaPOS.User;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
// "User" is a reserved SQL keyword and will cause errors.
@Table(name="app_user")
public class User {
    @Id
    @Column(name="phonenumber",unique = true)
    private String phonenumber;
    private String first_name;
    private String last_name;
    private String address;
    private boolean isManager;
    private String password;

    public User() {}


    public User(String id, String first_name, String last_name, String address,boolean isManager,String password) {
        this.phonenumber = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address= address;
        this.isManager=isManager;
        this.password=password;
    }

    // --- Getters and Setters (No Changes) ---
    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }


    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}