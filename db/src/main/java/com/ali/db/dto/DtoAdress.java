package com.ali.db.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoAdress {

    private Long id;
    private String description;
    private DtoCustomer dtoCustomer;
}
