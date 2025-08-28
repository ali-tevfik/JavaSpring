package com.ali.controller;

import com.ali.dto.Dtoaddress;
import com.ali.dto.DtoaddressIU;

public interface IRestAdressController {

    public RootEntity<Dtoaddress> saveAddress(DtoaddressIU address);
    
}
