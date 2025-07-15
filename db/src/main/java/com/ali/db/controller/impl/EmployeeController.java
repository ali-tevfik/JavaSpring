package com.ali.db.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ali.db.controller.IEmployeeController;
import com.ali.db.dto.DtoEmployee;
import com.ali.db.model.RootEntity;
import com.ali.db.services.IEmployeeService;

@RestController
@RequestMapping("/rest/api/employee")
public class EmployeeController extends BaseController implements IEmployeeController{

    @Autowired
    private IEmployeeService employeeService;
    
    @GetMapping(path = "/list")
    @Override
    public RootEntity<List<DtoEmployee>> listEmployee() {
        System.out.println("burda");
        return ok(employeeService.listEmployee());
    }

}
