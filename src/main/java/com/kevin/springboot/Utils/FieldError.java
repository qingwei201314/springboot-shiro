package com.kevin.springboot.Utils;

/**
 *  具体某个字段的验证结果
 *  @Author: Kevin Zhang @Date: 2021-1-14 11:43
**/
public class FieldError {
    private String fieldName;
    private int errorType;
    private String desc;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public int getErrorType() {
        return errorType;
    }

    public void setErrorType(int errorType) {
        this.errorType = errorType;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
