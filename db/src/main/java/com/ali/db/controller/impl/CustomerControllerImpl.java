package com.ali.db.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ali.db.controller.ICustomerController;
import com.ali.db.dto.DtoCustomer;
import com.ali.db.model.RootEntity;
import com.ali.db.services.ICustomerService;

@RestController
@RequestMapping("/rest/api/customer")
public class CustomerControllerImpl extends BaseController implements ICustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping(path = "/list/{id}")
    @Override
    public RootEntity<DtoCustomer> findCustomerById(@PathVariable(name = "id") Long id) {
     return ok(customerService.findCustomerById(id));
    }

}
