package com.kevin.springboot.test.controller;

import com.kevin.springboot.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *  spring boot 的测试类
 *  @Author: Kevin Zhang @Date: 2020-11-23 16:59
**/
@RestController
public class TestController {
    private boolean useLocalCache;
    @Autowired
    private TestService testService;

    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }

    @RequestMapping("/get")
    public boolean get() {
        return useLocalCache;
    }

    /**
     *  注册服务到Nacos
     *  @Author: Kevin Zhang @Date: 2020-11-25 9:42
    **/
    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string) {
        return testService.getString();
    }
}
