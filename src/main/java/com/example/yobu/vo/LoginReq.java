package com.example.yobu.vo;

import com.example.yobu.constants.ResMessage;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginReq {

    @NotBlank(message = ResMessage.ConstantsMessage.PARAM_EMAIL_REQUIRED)
    @Email(message = ResMessage.ConstantsMessage.PARAM_EMAIL_ERROR)
    private String email;

    @NotBlank(message = ResMessage.ConstantsMessage.PARAM_PASSWORD_REQUIRED)
    private String password;


    public LoginReq() {
        super();
    }

    public LoginReq(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
