package com.itbaizhan.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String sex;
    private String username;
    private String address;

    public User() {
    }

    public User(String username, String sex, String address) {
        this.username = username;
        this.sex = sex;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", sex='" + sex + '\'' +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User(int id, String username, String sex, String address) {
        this.id = id;
        this.sex = sex;
        this.username = username;
        this.address = address;
    }
}
