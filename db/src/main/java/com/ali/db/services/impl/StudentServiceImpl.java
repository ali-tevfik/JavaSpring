package com.ali.db.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ali.db.dto.DtoCourse;
import com.ali.db.dto.DtoStudent;
import com.ali.db.dto.DtoStudentIU;
import com.ali.db.entites.Course;
import com.ali.db.entites.Student;
import com.ali.db.exception.BaseException;
import com.ali.db.exception.ErrorMessage;
import com.ali.db.exception.MessegaType;
import com.ali.db.repository.StudentRepository;
import com.ali.db.services.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

  @Autowired
  private StudentRepository studentRepository;

  DtoStudent convertDto(Student student) {
    DtoStudent dto = new DtoStudent();
    BeanUtils.copyProperties(student, dto);
    return dto;
  }

  Student convertNormal(DtoStudent dto) {
    Student student = new Student();
    BeanUtils.copyProperties(dto, student);
    return student;
  }

  @Override
  public DtoStudent saveStudent(DtoStudentIU dtoStudent) {
    Student student = new Student();
    DtoStudent response = new DtoStudent();
    BeanUtils.copyProperties(dtoStudent, student);
    Student dbStudent = studentRepository.save(student);
    BeanUtils.copyProperties(dbStudent, response);
    return response;

  }

  @Override
  public void deleteStudent(Integer id) {
    studentRepository.deleteById(id);
  }

  @Override
  public DtoStudent updateStudent(Integer id, DtoStudentIU student) {

    Student student2 = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("student not found"));
    student2.setFirstName(student.getFirstName());
    student2.setLastName(student.getLastName());
    student2.setBirthOfDate(student.getBirthOfDate());
    studentRepository.save(student2);

    return convertDto(student2);
  }

  @Override
  public List<DtoStudent> allStudentList() {
    List<DtoStudent> dtoStudentList = new ArrayList<>();
    List<Student> allList = studentRepository.findAll();
    for (Student student : allList) {
      dtoStudentList.add(convertDto(student));
    }
    return dtoStudentList;
  }

  @Override
  public DtoStudent getStudentById(Integer id) {
    Optional<Student> optional = studentRepository.findById(id);
    if (optional.isEmpty()) {
      throw new BaseException(new ErrorMessage(MessegaType.NO_RECORD_EXITS, id.toString()));
    }

    List<Course> courses = optional.get().getCourses();
    List<DtoCourse> dtoCourses = new ArrayList<>();
    for (Course course : courses) {
      DtoCourse dtoCourse = new DtoCourse();
      BeanUtils.copyProperties(course, dtoCourse);
      dtoCourses.add(dtoCourse);
    }
    DtoStudent dtoStudent = convertDto(optional.get());
    dtoStudent.setDtoCourses(dtoCourses);

    return dtoStudent;
  }

}
