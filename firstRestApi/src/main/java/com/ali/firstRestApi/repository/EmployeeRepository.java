package com.ali.firstRestApi.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ali.firstRestApi.model.Employee;
import com.ali.firstRestApi.model.UpdateEmployeeRequest;

@Repository
public class EmployeeRepository {

    @Autowired
    private List<Employee> employeeList;

    public List<Employee> getAllEmployeeList() {

        return employeeList;
    }

    public Employee getEmployeeById(String id) {
        for (Employee employee : employeeList) {
            if (id.equals(employee.getId())) {
                return employee;
            }
        }
        return null;
    }

    public List<Employee> getEmployeeWithParams(String firstName, String lastName) {
        List<Employee> employeeWithParams = new ArrayList<>();
        if (firstName == null && lastName == null){
            System.out.println("ilk if");
            return employeeList;
        }

        for (Employee employee : employeeList) {
            if (firstName != null && lastName != null) {

                if (employee.getFirstName().equalsIgnoreCase(firstName)) {
                    if (employee.getLastName().equalsIgnoreCase(lastName)) {
                        System.out.println("ikinici if");
                        employeeWithParams.add(employee);
                    }
                } 

            }else if(firstName == null && lastName != null ){
                if(employee.getLastName().equalsIgnoreCase(lastName)){
                System.out.println("son if");

                    employeeWithParams.add(employee);
                }
            }else if(firstName != null && lastName == null){
                if(employee.getFirstName().equalsIgnoreCase(firstName)){
                    employeeWithParams.add(employee);
                }
            }
        }
        return employeeWithParams;
    }


    public Boolean saveEmployee(Employee employee){
            try{
                employeeList.add(employee);
                return true;
            }catch(Exception e){
                System.out.println(e.getMessage());
                return false;
            }
            
    }
    public Boolean deleteEmployee(String id){
        for(Employee employee:employeeList){
            if(employee.getId().equalsIgnoreCase(id)){
                employeeList.remove(employee);
                return true;
            }
        }
        
        return false;
    }


    public Employee updateEmployee(String id, UpdateEmployeeRequest updateEmployee){
        for(Employee employee:employeeList){
            System.out.println(employee.getId()+ "  " + id);
            if(employee.getId().equalsIgnoreCase(id)){
                System.out.println("find it");
                employeeList.remove(employee);
                Employee updatedEmployee = new Employee();
                updatedEmployee.setId(id);
                updatedEmployee.setFirstName(updateEmployee.getFirstName());
                updatedEmployee.setLastName(updateEmployee.getLastName());
                employeeList.add(updatedEmployee);
                return updatedEmployee;
            }
        }
        System.out.println("Retourn null");
        return null;
    }
}
