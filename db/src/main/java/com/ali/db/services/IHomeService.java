package com.ali.db.services;

import org.springframework.stereotype.Service;

import com.ali.db.dto.DtoHome;

@Service
public interface IHomeService {
   
    public DtoHome findHomeById(Long id);
}
