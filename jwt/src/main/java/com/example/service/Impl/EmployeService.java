package com.example.service.Impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.DtoDepartment;
import com.example.dto.DtoEmployee;
import com.example.model.Department;
import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import com.example.service.IEmployeeService;

@Service
public class EmployeService implements IEmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public DtoEmployee findEmployeeById(Long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        if(optional.isEmpty()){
            return null;
        }
        DtoEmployee dtoEmployee = new DtoEmployee();
        DtoDepartment dtoDepartment = new DtoDepartment();

        Employee employee = optional.get();
        Department department = employee.getDepartment();
        
        BeanUtils.copyProperties(employee, dtoEmployee);
        BeanUtils.copyProperties(department, dtoDepartment);
        dtoEmployee.setDepartment(dtoDepartment);
        
        return dtoEmployee;
        
    }
    
}
