package com.ali.db.controller;

import java.util.List;

import com.ali.db.dto.DtoEmployee;
import com.ali.db.model.RootEntity;

public interface IEmployeeController {
    public RootEntity<List<DtoEmployee>> listEmployee(); 

}
