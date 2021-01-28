package com.kevin.springboot.test.entity;

/**
 * 用户权限表
 *  @Author: Kevin Zhang @Date: 2021-1-28 10:38
**/
public class UserPermit {
    private Integer id;
    private String username;
    private String permit;

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

    public String getPermit() {
        return permit;
    }

    public void setPermit(String permit) {
        this.permit = permit;
    }
}
