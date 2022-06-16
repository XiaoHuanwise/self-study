package com.twt.selfstudy.entity;

public class LoginResponse {
    private int error_code;
    private String message;
    private LoginResult result;
    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
    public int getError_code() {
        return error_code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public void setResult(LoginResult result) {
        this.result = result;
    }
    public LoginResult getResult() {
        return result;
    }
}
