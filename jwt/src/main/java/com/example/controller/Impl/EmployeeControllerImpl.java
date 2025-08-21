package com.example.controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.IEmployeeController;
import com.example.dto.DtoEmployee;
import com.example.service.Impl.EmployeService;

import jakarta.validation.constraints.NotEmpty;

@RestController
@RequestMapping("/employee")
public class EmployeeControllerImpl implements IEmployeeController{

    @Autowired
    private EmployeService employeService;

    @GetMapping("/{id}")
    @Override
    public DtoEmployee findEmployeeById( @PathVariable(value = "id") Long id) {
        return employeService.findEmployeeById(id);
    }

}
