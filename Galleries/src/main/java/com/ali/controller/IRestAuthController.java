package com.ali.controller;

import com.ali.dto.AuthResponse;
import com.ali.dto.DtoAuthRequest;
import com.ali.dto.DtoUser;
import com.ali.dto.RefreshTokenRequest;

public interface IRestAuthController {

    public RootEntity<DtoUser> register(DtoAuthRequest input);
    public RootEntity<AuthResponse> authenticate(DtoAuthRequest input);
    public RootEntity<AuthResponse> refreshToken(RefreshTokenRequest refreshToken);
}
