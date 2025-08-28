package com.ali.controller;

import com.ali.dto.DtoAccount;
import com.ali.dto.DtoAccountIU;

public interface IRestAccountController {
    public RootEntity<DtoAccount> saveAccount(DtoAccountIU dtoAccountIU);
}
