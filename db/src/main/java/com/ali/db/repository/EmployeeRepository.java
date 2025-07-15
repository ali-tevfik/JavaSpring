package com.ali.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ali.db.entites.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
