package com.ali.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ali.dto.DtoAccount;
import com.ali.dto.DtoAccountIU;
import com.ali.model.Account;
import com.ali.repository.AccountRepository;
import com.ali.service.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;
    
    private Account createAccount(DtoAccountIU accountui){
        Account account = new Account();
        account.setCreateTime(new Date());
        BeanUtils.copyProperties(accountui, account);
        return account;
    }

    @Override
    public DtoAccount saveAccount(DtoAccountIU dtoAccountIU) {
        DtoAccount dtoAccount = new DtoAccount();
         Account savedAccount = accountRepository.save(createAccount(dtoAccountIU));
         BeanUtils.copyProperties(savedAccount, dtoAccount);
        return dtoAccount;
    }

}
