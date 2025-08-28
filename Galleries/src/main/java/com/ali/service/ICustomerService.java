package com.ali.service;

import com.ali.dto.DtoCustomer;
import com.ali.dto.DtoCustomerIU;

public interface ICustomerService {

    DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU);
}
