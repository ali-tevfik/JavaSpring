package com.ali.firstRestApi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.ali.firstRestApi.model.Employee;
import com.ali.firstRestApi.model.UpdateEmployeeRequest;
import com.ali.firstRestApi.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/rest/api/employee")
public class RestEmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/list")
    public List<Employee> getAllEmployeeList(){
        return employeeService.getAllEmployeeList();
       
    }
    


    @GetMapping("/list/{id}")
    public Employee getEmployeeById(@PathVariable(name="id", required = true) String id){
        return employeeService.getEmployeeById(id);
    }



    @GetMapping(path = "/list-with-params")
    public List<Employee> getEmployeesWithParams(@RequestParam(name="firstName",required = false)String firstName
                                                ,@RequestParam(name="lastName", required = false) String lastName){        
        return employeeService.getEmployeeWithParams(firstName, lastName);
    }

    @PostMapping(path = "/save-employee")
    public List<Employee> postMethodName(@RequestBody Employee newEmployee) {
        if(employeeService.saveEmployee(newEmployee)){
            System.out.println("Saved");
        }else{
            System.out.println("Error");
        }
        return employeeService.getAllEmployeeList();
    }
    
    @DeleteMapping(path = "/delete-employee/{id}")
    public boolean deleteEmployee(@PathVariable(name="id",required = true)String id){
        return employeeService.deleteEmployee(id);
        
    }

    //don't need to add a parameter to the URL for the request body.
    @PutMapping(path = "update-employee/{id}")
    public Employee updatEmployee(@PathVariable(name="id") String id, @RequestBody UpdateEmployeeRequest updateEmployee){
        return employeeService.updateEmployee(id, updateEmployee);
    }
}
