package com.ali.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ali.controller.IRestAccountController;
import com.ali.controller.RestBaseController;
import com.ali.controller.RootEntity;
import com.ali.dto.DtoAccount;
import com.ali.dto.DtoAccountIU;
import com.ali.service.IAccountService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/rest/api/account")
public class RestAccountImpl extends RestBaseController implements IRestAccountController{

    @Autowired
    private IAccountService iAccountService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoAccount> saveAccount(@Valid @RequestBody DtoAccountIU dtoAccountIU) {
        return ok(iAccountService.saveAccount(dtoAccountIU));
    }

}
