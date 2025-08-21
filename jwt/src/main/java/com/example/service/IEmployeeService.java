package com.example.service;

import com.example.dto.DtoEmployee;

public interface IEmployeeService {
    DtoEmployee findEmployeeById(Long id);
}
