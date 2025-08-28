package com.ali.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ali.controller.IRestAuthController;
import com.ali.controller.RestBaseController;
import com.ali.controller.RootEntity;
import com.ali.dto.AuthResponse;
import com.ali.dto.DtoAuthRequest;
import com.ali.dto.DtoUser;
import com.ali.dto.RefreshTokenRequest;
import com.ali.model.RefreshToken;
import com.ali.service.IAuthService;

import jakarta.validation.Valid;

@RestController
public class RestAuthControllerImpl extends RestBaseController implements IRestAuthController{

    @Autowired
    private IAuthService authService;

    @PostMapping("/register")
    @Override
    public RootEntity<DtoUser> register(@Valid @RequestBody DtoAuthRequest input) {
        return ok(authService.register(input));
    }

    @PostMapping("/authenticate")
    @Override
    public RootEntity<AuthResponse> authenticate(@Valid @RequestBody DtoAuthRequest input) {
        return ok(authService.authenticate(input));
    }

    @PostMapping("/refreshToken")
    @Override
    public RootEntity<AuthResponse> refreshToken(@Valid @RequestBody RefreshTokenRequest refreshToken) {
       return ok(authService.refreshToken(refreshToken));
    }

}