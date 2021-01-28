package com.kevin.springboot.Utils.Exceptionhandler;

import com.kevin.springboot.Utils.FieldError;
import com.kevin.springboot.Utils.ValidateException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *  处理controller中抛出的ValidateException
 *  @Author: Kevin Zhang @Date: 2021-1-18 8:58
**/
@ControllerAdvice(basePackages = "com.kevin.springboot.test")
public class HandleException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ValidateException.class)
    @ResponseBody
    String handleControllerException(HttpServletRequest request, ValidateException ve) {
        List<FieldError> list = new ArrayList<>(ve.getResults().values());
//        String result = JSON.toJSONString(list);
        return null;
    }


}
