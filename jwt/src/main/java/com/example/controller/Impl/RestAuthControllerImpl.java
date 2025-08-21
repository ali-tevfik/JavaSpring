package com.example.controller.Impl;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.IRestAuthController;
import com.example.dto.DtoUser;
import com.example.jwt.AuthRequest;
import com.example.jwt.AuthResponse;
import com.example.service.IAuthService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
;

@RestController
public class RestAuthControllerImpl implements IRestAuthController {

    @Autowired
    private IAuthService authService;

    @PostMapping("/register")
    @Override
    public DtoUser register(@Valid @RequestBody AuthRequest request){
            return authService.register(request);
    }

    @PostMapping("/authenticate")
    @Override
    public AuthResponse authenticate(@Valid @RequestBody AuthRequest request) {
        System.out.println("Amcik");
        return authService.authenticate(request);
    }
}
