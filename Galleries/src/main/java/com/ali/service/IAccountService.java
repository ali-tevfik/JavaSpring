package com.ali.service;

import com.ali.dto.DtoAccount;
import com.ali.dto.DtoAccountIU;

public interface IAccountService {
    public DtoAccount saveAccount(DtoAccountIU dtoAccountIU);
}
