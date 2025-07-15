package com.ali.db.controller;

import org.springframework.web.bind.annotation.PathVariable;

import com.ali.db.dto.DtoAdress;
import com.ali.db.model.RootEntity;


public interface IAdressController {
       public RootEntity<DtoAdress> findAdressById(@PathVariable(name = "id")Long id);
}