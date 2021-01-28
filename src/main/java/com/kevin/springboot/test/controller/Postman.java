package com.kevin.springboot.test.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Postman {
    @RequestMapping(method = RequestMethod.POST, value = "/postman")
    public String postman(String name, String age) {
        System.out.println("name:" + name);
        System.out.println("age:" + age);
        String result = name + "," + age;
        return result;
    }
}
