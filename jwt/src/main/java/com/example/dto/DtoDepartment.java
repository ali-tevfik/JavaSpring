package com.example.dto;

import com.example.model.Department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoDepartment {
    private Long id;
    private String name;
    private String location;
}
