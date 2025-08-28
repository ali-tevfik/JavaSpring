package com.ali.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ali.controller.IRestAdressController;
import com.ali.controller.RestBaseController;
import com.ali.controller.RootEntity;
import com.ali.dto.Dtoaddress;
import com.ali.dto.DtoaddressIU;
import com.ali.service.IAddressService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/address")
public class RestAddressControllerImpl extends RestBaseController implements IRestAdressController{

    @Autowired
    private IAddressService addressService;

    @PostMapping("/save")
    @Override
    public RootEntity<Dtoaddress> saveAddress(@Valid @RequestBody DtoaddressIU address) {
        return ok(addressService.saveAddress(address));
    }

}
