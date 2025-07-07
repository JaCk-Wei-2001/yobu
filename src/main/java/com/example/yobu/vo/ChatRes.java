package com.example.yobu.vo;

import java.util.List;

public class ChatRes extends BasicRes {

    private String res;

    private List<LocationVo> location;

    public ChatRes() {
        super();
    }

    public ChatRes(int code, String message) {
        super(code, message);
    }


    public ChatRes(int code, String message, String res, List<LocationVo> location) {
        super(code, message);
        this.res = res;
        this.location = location;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public void setLocation(List<LocationVo> location) {
        this.location = location;
    }

    public String getRes() {
        return res;
    }

    public List<LocationVo> getLocation() {
        return location;
    }
}