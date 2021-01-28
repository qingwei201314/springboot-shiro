package com.kevin.springboot.test.entity;

/**
 *  角色权限表对应的实体
 *  @Author: Kevin Zhang @Date: 2021-1-27 14:10
**/
public class RolePermission {
    private Integer id;
    private String role_id;
    private String permission;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
