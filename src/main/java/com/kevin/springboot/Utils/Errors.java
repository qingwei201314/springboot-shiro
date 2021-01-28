package com.kevin.springboot.Utils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *  后端验证错误集合.
 *  @Author: Kevin Zhang @Date: 2021-1-14 11:34
**/
public class Errors {
    private Map<String, FieldError> results = new LinkedHashMap<String, FieldError>();

    public void put(String field, ErrorEnum errorEnum){
        FieldError fieldError = new FieldError();
        fieldError.setFieldName(field);
        fieldError.setErrorType(errorEnum.getErrorType());
        fieldError.setDesc(errorEnum.getDesc());
        results.put(field, fieldError);
    }

    public void put(String field, int errorType, String desc){
        FieldError fieldError = new FieldError();
        fieldError.setFieldName(field);
        fieldError.setErrorType(errorType);
        fieldError.setDesc(desc);
        results.put(field, fieldError);
    }

    public void validate() throws ValidateException {
        if(results.keySet().size() > 0){
            throw new ValidateException(results);
        }
    }
}
