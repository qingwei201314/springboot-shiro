package com.kevin.springboot.Utils;

import java.util.Map;

public class ValidateException extends Exception{
    private Map<String, FieldError> results;

    public ValidateException(Map<String, FieldError> results){
        this.results = results;
    }

    public Map<String, FieldError> getResults() {
        return results;
    }

    public void setResults(Map<String, FieldError> results) {
        this.results = results;
    }
}
