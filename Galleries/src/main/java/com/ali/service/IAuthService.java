package com.ali.service;

import com.ali.dto.AuthResponse;
import com.ali.dto.DtoAuthRequest;
import com.ali.dto.DtoUser;
import com.ali.dto.RefreshTokenRequest;

public interface IAuthService {
    public DtoUser register(DtoAuthRequest input);
    public AuthResponse authenticate(DtoAuthRequest input);
    public AuthResponse refreshToken(RefreshTokenRequest refreshToken);
}
