package com.notmyfault02.data.entity;

public class SignupResponse {
    private int code;
    private String data;
    private String msg;
    private boolean success;

    public int getCode() {
        return code;
    }

    public String getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public boolean isSuccess() {
        return success;
    }
}
