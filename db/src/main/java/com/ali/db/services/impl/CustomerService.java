package com.ali.db.services.impl;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ali.db.dto.DtoAdress;
import com.ali.db.dto.DtoCustomer;
import com.ali.db.entites.Adress;
import com.ali.db.entites.Customer;
import com.ali.db.exception.BaseException;
import com.ali.db.exception.ErrorMessage;
import com.ali.db.exception.MessegaType;
import com.ali.db.repository.CustomerRepository;
import com.ali.db.services.ICustomerService;

@Service
public class CustomerService implements ICustomerService{

    @Autowired
    private CustomerRepository customerReposoitory;

    @Override
    public DtoCustomer findCustomerById(Long id) {
        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoAdress dtoAdress = new DtoAdress();
        Optional<Customer> optional = customerReposoitory.findById(id);
        
        if(optional.isEmpty()){
            throw new BaseException(new ErrorMessage(MessegaType.NO_RECORD_EXITS, id.toString()));
        }
        Customer customer = optional.get();
        Adress adress = optional.get().getAdress();
        BeanUtils.copyProperties(customer, dtoCustomer);
        BeanUtils.copyProperties(adress, dtoAdress);
            dtoCustomer.setAdress(dtoAdress);
        return dtoCustomer;
    }

}
