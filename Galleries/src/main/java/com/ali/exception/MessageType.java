package com.ali.exception;

import lombok.Getter;

@Getter
public enum MessageType {
    NO_RECORD_EXITS("1004","No record found"),
    GENERAL_EXCEPTION("9999","Error"),
    TOKEN_IS_EXPIRED("1005","Token date expired"),
    REFRESH_TOKEN_NOT_FOUND("1008","Invalid refresh token"),
    REFRESH_TOKEN_IS_EXPIRED("1008","Refresh token expired"),
    USERNAMEORPASSWORDINVALID("1007","invalid username or password"),
    USERNAME_NOT_FOUND("1006","Username not found");

    private String code;
    private String message;

    MessageType(String code,String message){
        this.code = code;
        this.message = message;
    }
}
