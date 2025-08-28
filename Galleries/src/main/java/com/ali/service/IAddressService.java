package com.ali.service;

import com.ali.dto.Dtoaddress;
import com.ali.dto.DtoaddressIU;

public interface IAddressService {
    public Dtoaddress saveAddress(DtoaddressIU dtoaddressIU);

}
