package com.example.yobu.constants;

public enum ResMessage {
    SUCCESS(200, "Success!!"), //

    EMAIL_ALREADY_REGISTERED(400, "Email already registered!!"),//
    EMAIL_NOT_FOUND(400, "Email not found"), //
    PASSWORD_DO_NOT_MATCH(400, "Password do not match");

    public int code;

    public String message;

    ResMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static class ConstantsMessage {
        public static final String PARAM_EMAIL_REQUIRED = "Param_email required!!";
        public static final String PARAM_EMAIL_ERROR = "Param_email error!!";
        public static final String PARAM_PASSWORD_REQUIRED = "Param_password required!!";
        public static final String PARAM_NAME_ERROR = "Param_name error!!";
        public static final String PARAM_USER_ID_ERROR = "Param_user_id error!!";
        public static final String PARAM_USERMESSAGE_REQUIRED = "Param_userMessage required!!";

    }
}
