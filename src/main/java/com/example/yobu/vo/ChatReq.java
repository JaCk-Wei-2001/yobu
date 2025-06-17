package com.example.yobu.vo;


import com.example.yobu.constants.ResMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ChatReq {

//    @NotNull(message = ResMessage.ConstantsMessage.PARAM_USER_ID_ERROR)
//    private int userId;

    @NotBlank(message = ResMessage.ConstantsMessage.PARAM_USERMESSAGE_REQUIRED)
    private String userMessage;

    public ChatReq() {
        super();
    }

    public ChatReq(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getUserMessage() {
        return userMessage;
    }
}
