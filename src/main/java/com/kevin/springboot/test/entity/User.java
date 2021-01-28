package com.kevin.springboot.test.entity;

public class User {
    private  Integer id;
    private String username;
    private String password;
    private Integer password_salt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPassword_salt() {
        return password_salt;
    }

    public void setPassword_salt(Integer password_salt) {
        this.password_salt = password_salt;
    }
}
