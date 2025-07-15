package com.ali.db.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ali.db.dto.DtoEmployee;

@Service
public interface IEmployeeService {

    public List<DtoEmployee> listEmployee();

}
