package com.ali.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ali.db.entites.Student;

@Repository
public interface StudentRepository  extends JpaRepository<Student,Integer>{
    
}
