package com.example.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jwt.AuthResponse;
import com.example.jwt.JwtService;
import com.example.jwt.RefreshTokenRequest;
import com.example.repository.RefreshTokenRepository;
import com.example.service.IRefresTokenService;
import com.example.model.RefreshToken;
import com.example.model.User;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenServiceImpl implements IRefresTokenService{

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;
    

    @Autowired
    private JwtService jwtService;


    private RefreshToken createRefreshToken(User user){
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        refreshToken.setExpiredDate(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 4));
        refreshToken.setUser(user);
        return refreshToken;
    }

public boolean isRefreshTokenExpired(Date expiredDate){
    return new Date().before(expiredDate);
}

    @Override
    public AuthResponse refreshToken(RefreshTokenRequest request) {
        Optional<RefreshToken> optional = refreshTokenRepository.findByRefreshToken(request.getRefreshToken());
        if(optional.isEmpty()){
            System.err.println("Refresh token not accepted!");
        }
        RefreshToken refreshToken = optional.get();
        if(!isRefreshTokenExpired(refreshToken.getExpiredDate())){
            System.err.println("Refrest token expired");
        }
        String accesToken = jwtService.generateToken(refreshToken.getUser());
        RefreshToken savRefreshToken =  refreshTokenRepository.save(createRefreshToken(refreshToken.getUser()));
        return new AuthResponse(accesToken, savRefreshToken.getRefreshToken());
    }

}
