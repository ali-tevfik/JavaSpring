package com.example.service;

import com.example.jwt.AuthResponse;
import com.example.jwt.RefreshTokenRequest;
import com.example.model.RefreshToken;

public interface IRefresTokenService {
    public AuthResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
