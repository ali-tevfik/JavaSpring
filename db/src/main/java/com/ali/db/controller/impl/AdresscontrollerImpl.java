package com.ali.db.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ali.db.controller.IAdressController;
import com.ali.db.dto.DtoAdress;
import com.ali.db.model.RootEntity;
import com.ali.db.services.IAdressService;

@RestController
@RequestMapping("/rest/api/adress")
public class AdresscontrollerImpl  extends BaseController implements IAdressController{

    @Autowired
    private IAdressService adressService;

    @GetMapping(path = "list/{id}")
    @Override
    public RootEntity<DtoAdress> findAdressById(@PathVariable(name = "id")Long id) {
       return ok(adressService.findAdressById(id));
    }

}
