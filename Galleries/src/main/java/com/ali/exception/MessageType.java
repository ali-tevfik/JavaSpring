package com.ali.exception;

import lombok.Getter;

@Getter
public enum MessageType {
    NO_RECORD_EXITS("1004","No record found"),
    GENERAL_EXCEPTION("9999","Error");

    private String code;
    private String message;

    MessageType(String code,String message){
        this.code = code;
        this.message = message;
    }
}
