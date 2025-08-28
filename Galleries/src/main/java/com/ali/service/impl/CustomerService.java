package com.ali.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ali.dto.DtoAccount;
import com.ali.dto.DtoCustomer;
import com.ali.dto.DtoCustomerIU;
import com.ali.dto.Dtoaddress;
import com.ali.exception.BaseException;
import com.ali.exception.ErrorMessage;
import com.ali.exception.MessageType;
import com.ali.model.Account;
import com.ali.model.Address;
import com.ali.model.Customer;
import com.ali.repository.AccountRepository;
import com.ali.repository.CustomerRepository;
import com.ali.repository.addressRepository;
import com.ali.service.ICustomerService;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private AccountRepository accountRepository;


    @Autowired
    private addressRepository addressRepository;

    @Autowired
    private CustomerRepository customerRepository;

    private Customer createCustomer(DtoCustomerIU dtoCustomerIU){
        
        Optional<Account> optAccount = accountRepository.findById(dtoCustomerIU.getAccountID());
        if(optAccount.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXITS,dtoCustomerIU.getAccountID().toString()));
        }
        Optional<Address> optAddress = addressRepository.findById(dtoCustomerIU.getAddressID());
        if(optAddress.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXITS,dtoCustomerIU.getAddressID().toString()));
        }

        Customer customer = new Customer();
        customer.setCreateTime(new Date());
        BeanUtils.copyProperties(dtoCustomerIU, customer);
        customer.setAddress(optAddress.get());
        customer.setAccount(optAccount.get());

        return customer;
    }

    @Override
    public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU) {
       Customer savedCustomer = customerRepository.save(createCustomer(dtoCustomerIU));
       DtoCustomer dtoCustomer = new DtoCustomer();

       BeanUtils.copyProperties(savedCustomer, dtoCustomer);

        Dtoaddress dtoaddress = new Dtoaddress();
        DtoAccount dtoAccount = new DtoAccount();

        BeanUtils.copyProperties(savedCustomer.getAccount(), dtoAccount);
        BeanUtils.copyProperties(savedCustomer.getAddress(), dtoaddress);
        dtoCustomer.setAddress(dtoaddress);
        dtoCustomer.setAccount(dtoAccount);

       return dtoCustomer;
    }

}
