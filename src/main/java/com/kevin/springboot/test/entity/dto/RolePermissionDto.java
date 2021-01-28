package com.kevin.springboot.test.entity.dto;

import com.kevin.springboot.test.entity.RolePermission;

public class RolePermissionDto extends RolePermission {
    //role表的name
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
