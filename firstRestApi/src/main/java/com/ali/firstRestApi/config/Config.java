package com.ali.firstRestApi.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ali.firstRestApi.model.Employee;

@Configuration
public class Config {

    //fake data
    @Bean
    public List<Employee> employeeList(){
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("1","Ali","doner"));
        employees.add(new Employee("2","veli","doner"));
        employees.add(new Employee("3","Ali3","doner"));
        employees.add(new Employee("4","deli","doner"));
        employees.add(new Employee("5","veli3","doner5"));
        employees.add(new Employee("6","deli","doner6"));
        return employees;
    }
}
