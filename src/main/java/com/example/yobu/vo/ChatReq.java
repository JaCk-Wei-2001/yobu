package com.example.yobu.vo;


import com.example.yobu.constants.ResMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ChatReq {

<<<<<<< HEAD
//    @NotNull(message = ResMessage.ConstantsMessage.PARAM_USER_ID_ERROR)
//    private int userId;
=======
    @NotNull(message = ResMessage.ConstantsMessage.PARAM_USER_ID_ERROR)
    private int userId;
>>>>>>> d20e27d279a402c12c9d1f0c080dc925d6773d44

    @NotBlank(message = ResMessage.ConstantsMessage.PARAM_USERMESSAGE_REQUIRED)
    private String userMessage;

    public ChatReq() {
        super();
    }

<<<<<<< HEAD
    public ChatReq(String userMessage) {
        this.userMessage = userMessage;
    }

=======
    public ChatReq(int userId, String userMessage) {
        this.userId = userId;
        this.userMessage = userMessage;
    }

    public int getUserId() {
        return userId;
    }

>>>>>>> d20e27d279a402c12c9d1f0c080dc925d6773d44
    public String getUserMessage() {
        return userMessage;
    }
}
