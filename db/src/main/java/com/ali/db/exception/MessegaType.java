package com.ali.db.exception;

import lombok.Getter;

@Getter
public enum MessegaType {
    NO_RECORD_EXITS("1001","not found"),
    GENERAL_EXCEPTION("9999","GENERAL ERROR");

    private String code;
    private String message;

    MessegaType(String code,String message){
        this.code = code;
        this.message =message;
    }
    
}
