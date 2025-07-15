package com.ali.db.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ali.db.controller.IHomeController;
import com.ali.db.dto.DtoHome;
import com.ali.db.model.RootEntity;
import com.ali.db.services.IHomeService;

@RestController
@RequestMapping("/rest/api/home")
public class HomeController extends BaseController  implements IHomeController{

    @Autowired
    private IHomeService homeService;
    
    @GetMapping("/{id}")
    @Override
    public RootEntity<DtoHome> findHomeById(@PathVariable(name = "id")Long id) {
        return ok(homeService.findHomeById(id));
    }

}
