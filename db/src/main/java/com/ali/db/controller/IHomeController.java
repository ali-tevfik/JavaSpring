package com.ali.db.controller;

import com.ali.db.dto.DtoHome;
import com.ali.db.model.RootEntity;

public interface IHomeController {
    public RootEntity<DtoHome> findHomeById(Long id);
}
