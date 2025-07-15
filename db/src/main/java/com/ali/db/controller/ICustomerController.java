package com.ali.db.controller;


import com.ali.db.dto.DtoCustomer;
import com.ali.db.model.RootEntity;

public interface ICustomerController {

        public RootEntity<DtoCustomer>  findCustomerById(Long id);

}
