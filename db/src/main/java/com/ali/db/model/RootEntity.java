package com.ali.db.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RootEntity<T> {
    private Boolean result;
    private String errorMessage;
    private T data;
    
    
    public static <T>RootEntity<T> ok(T data){
        RootEntity<T> response = new RootEntity();
        response.setResult(true);
        response.setErrorMessage(null);
        response.setData(data);
        return response;
    }

    public static <T>RootEntity<T> error(String errorMessage){
        RootEntity<T> response = new RootEntity();
        response.setResult(false);
        response.setErrorMessage(errorMessage);
        response.setData(null);
        return response;
    }
}
