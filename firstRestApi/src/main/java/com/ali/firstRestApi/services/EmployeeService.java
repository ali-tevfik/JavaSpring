package com.ali.firstRestApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ali.firstRestApi.model.Employee;
import com.ali.firstRestApi.model.UpdateEmployeeRequest;
import com.ali.firstRestApi.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public List<Employee> getAllEmployeeList(){
        return employeeRepository.getAllEmployeeList();
        
       
    }
    

    public Employee getEmployeeById(String id){
        return employeeRepository.getEmployeeById(id);
    }


    public List<Employee> getEmployeeWithParams(String firstName, String lastName) {
    return employeeRepository.getEmployeeWithParams(firstName, lastName);
    }
    public Boolean saveEmployee(Employee employee){
        return employeeRepository.saveEmployee(employee);
    }

    public Boolean deleteEmployee(String id){
        return employeeRepository.deleteEmployee(id);
    }

        public Employee updateEmployee(String id, UpdateEmployeeRequest updateEmployee){
            return employeeRepository.updateEmployee(id, updateEmployee);
        }
}
