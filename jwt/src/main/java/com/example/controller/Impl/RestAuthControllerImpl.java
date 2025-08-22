package com.example.controller.Impl;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.IRestAuthController;
import com.example.dto.DtoUser;
import com.example.jwt.AuthRequest;
import com.example.jwt.AuthResponse;
import com.example.jwt.RefreshTokenRequest;
import com.example.service.IAuthService;
import com.example.service.IRefresTokenService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
;

@RestController
public class RestAuthControllerImpl implements IRestAuthController {

    @Autowired
    private IAuthService authService;


    @Autowired
    private IRefresTokenService refresTokenService;

    
    @PostMapping("/register")
    @Override
    public DtoUser register(@Valid @RequestBody AuthRequest request){
            return authService.register(request);
    }

    @PostMapping("/authenticate")
    @Override
    public AuthResponse authenticate(@Valid @RequestBody AuthRequest request) {
        return authService.authenticate(request);
    }


    
    @PostMapping("/refreshToken")
    @Override
    public AuthResponse refreshToken(@RequestBody RefreshTokenRequest refreshToken) {
        return refresTokenService.refreshToken(refreshToken);
    }
}
