package com.kevin.springboot.test.controller;

import com.kevin.springboot.Utils.ValidateException;
import com.kevin.springboot.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidateInput {
    @Autowired
    private TestService testService;

    @RequestMapping(value = "/validate")
    public String validate(String name, int age, String country) throws ValidateException {
        testService.testValidate(null, 40,  "dd");
        return "Kevin";
    }

}
