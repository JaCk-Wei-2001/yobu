package com.example.yobu.vo;

import com.example.yobu.constants.ResMessage;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class RegisterReq {

    @NotBlank(message = ResMessage.ConstantsMessage.PARAM_EMAIL_REQUIRED)
    @Email(message = ResMessage.ConstantsMessage.PARAM_EMAIL_ERROR)
    private String email;

    @NotBlank(message = ResMessage.ConstantsMessage.PARAM_PASSWORD_REQUIRED)
    private String password;

    @NotBlank(message = ResMessage.ConstantsMessage.PARAM_NAME_ERROR)
    private String name;

    public RegisterReq() {
        super();
    }

    public RegisterReq(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
