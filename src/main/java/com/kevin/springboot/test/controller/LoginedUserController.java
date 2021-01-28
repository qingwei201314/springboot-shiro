package com.kevin.springboot.test.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/LoginedUserController")
public class LoginedUserController {

    @RequestMapping(value = "/admin")
    @RequiresAuthentication
    public String adminConfig(Model model) {
        Subject currentUser = SecurityUtils.getSubject();
        System.out.println("currentUser.isAuthenticated(): " + currentUser.isAuthenticated());
        return "view";
    }

    @RequestMapping(value = "/hasRoles")
    @RequiresRoles("admin")
    public String hasRoles() {
        return "hasRoles";
    }

    @RequiresPermissions("admin:read")
    @RequestMapping(value = "/hasPermisstion")
    public String hasPermisstion() {
        return "hasPermisstion";
    }
}
