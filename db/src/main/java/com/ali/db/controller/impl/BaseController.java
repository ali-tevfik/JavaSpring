package com.ali.db.controller.impl;

import com.ali.db.model.RootEntity;

public class BaseController {

  public   <T> RootEntity<T> ok(T data){
    return RootEntity.ok(data);
  } 

  public   <T> RootEntity<T> errorMessage(String errorMessage){
    return RootEntity.error(errorMessage);
  } 
}
