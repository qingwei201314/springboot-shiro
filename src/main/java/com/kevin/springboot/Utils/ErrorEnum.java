package com.kevin.springboot.Utils;

public enum ErrorEnum {
    EMPTY(-1, "不能为空");

    private int errorType;
    private String desc;
    ErrorEnum(int errorType, String desc){
        this.errorType = errorType;
        this.desc = desc;
    }

    public int getErrorType(){
        return this.errorType;
    }
    public String getDesc(){
        return this.desc;
    }
}
