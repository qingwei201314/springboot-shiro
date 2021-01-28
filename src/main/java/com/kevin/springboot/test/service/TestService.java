package com.kevin.springboot.test.service;

import com.kevin.springboot.Utils.ErrorEnum;
import com.kevin.springboot.Utils.Errors;
import com.kevin.springboot.Utils.ValidateException;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    public String getString()  {
        return "Hello Kevin.";
    }

    public void testValidate(String name, int age, String country) throws ValidateException {
        // 验证
        Errors errors = new Errors();
        if(name == null){
            errors.put("name", ErrorEnum.EMPTY);
        }
        if(age < 60){
            errors.put("age", 1, "人员未退休");
        }
        if(!"China".equals(country)){
            errors.put("country", 2, "只能填中国");
        }
        errors.validate();
    }
}
