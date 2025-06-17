package com.example.yobu.vo;

public class LoginRes extends BasicRes{

    private String token;

    public LoginRes() {
        super();
    }

    public LoginRes(int code, String message) {
        super(code, message);
    }

    public LoginRes(int code, String message, String token) {
        super(code, message);
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
