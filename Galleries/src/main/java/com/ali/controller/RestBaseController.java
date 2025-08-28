package com.ali.controller;

public class RestBaseController {
    
    public <T> RootEntity<T> ok(T payload){
        return RootEntity.ok(payload);
    }
    public <T> RootEntity<T> error(String error){
        return RootEntity.error(error);
    }
}
