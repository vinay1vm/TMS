package com.example.tms05;

public class DataStorage {
    String name,email,phoneNo,doorNo,password;

    public DataStorage() {

    }

    public DataStorage(String name, String email, String phoneNo, String doorNo, String password) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.doorNo = doorNo;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
