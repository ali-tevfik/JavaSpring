package com.ali.db.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ali.db.controller.IStudentController;
import com.ali.db.dto.DtoStudent;
import com.ali.db.dto.DtoStudentIU;
import com.ali.db.model.RootEntity;
import com.ali.db.services.IStudentService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("rest/api/student")
public class StudentControllerImpl extends BaseController implements IStudentController {

    @Autowired
    private IStudentService studentService;




    @DeleteMapping(path = "delete/{id}")
    @Override
    public void deleteStudent(@PathVariable(name = "id")Integer id){
        studentService.deleteStudent(id);
    }

    @PostMapping(path = "/save")
    @Override
    public RootEntity<DtoStudent> saveStudent(@RequestBody  @Valid DtoStudentIU student) {
      
        return ok(studentService.saveStudent(student));
    }

 

    @Override
    @GetMapping(path = "/all-list")
    public RootEntity<List<DtoStudent>> allStudentList() {
        return  ok(studentService.allStudentList());
    }

    @PutMapping("update/{id}")
    @Override
    public RootEntity<DtoStudent> updateStudent(@PathVariable(name = "id") Integer id, @RequestBody DtoStudentIU updaStudent) {
    
        return ok(studentService.updateStudent(id,updaStudent));
    }

    @Override
    @GetMapping("/list/{id}")
    public RootEntity<DtoStudent> getStudentById(@PathVariable(name = "id") Integer id) {
        return ok(studentService.getStudentById(id));
      
    }




}
