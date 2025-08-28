package com.ali.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ali.controller.IRestCustomerController;
import com.ali.controller.RestBaseController;
import com.ali.controller.RootEntity;
import com.ali.dto.DtoCustomer;
import com.ali.dto.DtoCustomerIU;
import com.ali.service.ICustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/customer")
public class RestCustomerControllerImpl extends RestBaseController implements IRestCustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoCustomer> createCustomer(@Valid @RequestBody DtoCustomerIU dtoCustomerIU) {
         return ok(iCustomerService.saveCustomer(dtoCustomerIU));
    }

}
