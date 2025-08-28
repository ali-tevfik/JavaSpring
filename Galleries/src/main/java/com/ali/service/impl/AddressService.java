package com.ali.service.impl;


import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ali.dto.Dtoaddress;
import com.ali.dto.DtoaddressIU;
import com.ali.service.IAddressService;
import com.ali.model.Address;
import com.ali.repository.addressRepository;

@Service
public class AddressService implements IAddressService{

    @Autowired
    private addressRepository addressRepository;

    private Address createAddress(DtoaddressIU dtoaddressIU){
        Address address=new Address();
        address.setCreateTime(new Date());
        BeanUtils.copyProperties(dtoaddressIU, address);
        return address;
    }

    @Override
    public Dtoaddress saveAddress(DtoaddressIU dtoaddressIU) {
        Address address = addressRepository.save(createAddress(dtoaddressIU));
        Dtoaddress dtoaddress = new Dtoaddress();
        BeanUtils.copyProperties(address, dtoaddress);
        
        return dtoaddress;
    }

}
