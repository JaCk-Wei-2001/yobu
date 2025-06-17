package com.example.yobu.vo;

public class BasicRes {

    private int code;

    private String message;

    public BasicRes() {
        super();
    }

    public BasicRes(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
