package com.ali.db.services;

import com.ali.db.dto.DtoAdress;

public interface IAdressService {
    public DtoAdress findAdressById(Long id);
}
