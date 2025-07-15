package com.ali.db.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    private MessegaType messegaType;
    private String ofStatic;

    public String prepareErrorMessage(){
        StringBuilder builder = new StringBuilder();
        builder.append(messegaType.getMessage());
        if(ofStatic != null){
            builder.append(" : " + ofStatic);
        }
        return builder.toString();
    }
}
