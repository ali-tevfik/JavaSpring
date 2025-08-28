package com.ali.controller;

import com.ali.dto.DtoCustomer;
import com.ali.dto.DtoCustomerIU;

public interface IRestCustomerController {
    public RootEntity<DtoCustomer> createCustomer(DtoCustomerIU dtoCustomerIU);
}
