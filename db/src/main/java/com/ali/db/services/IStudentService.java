package com.ali.db.services;

import java.util.List;

import com.ali.db.dto.DtoStudent;
import com.ali.db.dto.DtoStudentIU;

public interface IStudentService {

    public DtoStudent saveStudent(DtoStudentIU student);
    public void deleteStudent(Integer id);
    public DtoStudent updateStudent(Integer id,DtoStudentIU student);
    public List<DtoStudent> allStudentList();
    public DtoStudent getStudentById(Integer id);

}
