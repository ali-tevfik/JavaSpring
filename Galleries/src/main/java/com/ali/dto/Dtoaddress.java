package com.ali.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dtoaddress extends DtoBase{
    private String city;
    private String district;
    private String neighborhood;
    private String street;
}
