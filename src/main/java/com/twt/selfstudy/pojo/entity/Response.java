package com.twt.selfstudy.pojo.entity;

import java.util.HashMap;
import java.util.Map;

public class Response {
    private int error_code;
    private String message;
    private Map<String,Object> data = new HashMap<>();

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
