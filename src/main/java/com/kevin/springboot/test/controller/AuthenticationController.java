package com.kevin.springboot.test.controller;

import com.kevin.springboot.test.dao.UserDao;
import com.kevin.springboot.test.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *  shiro权限控制
 *  @Author: Kevin Zhang @Date: 2021-1-21 8:36
**/
@RestController
@RequestMapping("/AuthenticationController")
public class AuthenticationController {
    @Autowired
    private UserDao userDao;

    /**
     *  登录
     *  @Author: Kevin Zhang @Date: 2021-1-25 11:37
    **/
    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public User login(String username, String password) {
        User user = userDao.selectUserById(1);
        if(user.getUsername().equals(username) && user.getPassword().equals(password)){
            //如果登录成功
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(true);
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.isPermitted("admin:read");
            currentUser.login(token);
        } else {
            //登录失败
            user.setId(0);
            user.setUsername("没有此人");
            user.setPassword(null);
        }
        return user;
    }

}
