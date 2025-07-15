package com.ali.db.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.ali.db.dto.DtoStudent;
import com.ali.db.dto.DtoStudentIU;
import com.ali.db.model.RootEntity;


public interface IStudentController {

    public RootEntity<DtoStudent> saveStudent(DtoStudentIU student);
    public void deleteStudent(@PathVariable(name = "id")Integer id);
    public RootEntity<DtoStudent> updateStudent(Integer id, DtoStudentIU student);
    public RootEntity<List<DtoStudent>> allStudentList();
    public RootEntity<DtoStudent> getStudentById(Integer id);
}
