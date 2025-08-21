package com.example.controller;

import com.example.dto.DtoEmployee;

public interface IEmployeeController {
    public DtoEmployee findEmployeeById(Long id);

}
