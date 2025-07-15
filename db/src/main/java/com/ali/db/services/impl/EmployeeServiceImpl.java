package com.ali.db.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ali.db.dto.DtoDepartmant;
import com.ali.db.dto.DtoEmployee;
import com.ali.db.entites.Employee;
import com.ali.db.repository.EmployeeRepository;
import com.ali.db.services.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<DtoEmployee> listEmployee() {
            List<Employee> employees = employeeRepository.findAll();
            List<DtoEmployee> dtoEmployees = new ArrayList<>();
            if(employees !=null && !employees.isEmpty()){
                for(Employee employee: employees){
                    DtoEmployee dtoEmployee = new DtoEmployee();
                    BeanUtils.copyProperties(employee, dtoEmployee);
                    dtoEmployee.setDtoDepartmant(new DtoDepartmant(employee.getDepartmant().getId(),employee.getDepartmant().getDepartmantName()));
                    dtoEmployees.add(dtoEmployee);
                }
            }else return null;
            return dtoEmployees;
    }

}
