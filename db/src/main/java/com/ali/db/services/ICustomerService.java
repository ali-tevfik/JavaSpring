package com.ali.db.services;

import com.ali.db.dto.DtoCustomer;

public interface ICustomerService {

    public DtoCustomer  findCustomerById(Long id);


}
