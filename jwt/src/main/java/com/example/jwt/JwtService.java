package com.example.jwt;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;



@Component
public class JwtService {

    private static final String SECRET_KEY = "ogXO8fxtSOF4H6JHsJdraLw9XJ53mSLRFYeTFR74N0Y=";
    
    public String generateToken(UserDetails userDetails){
        Map<String,Object> claimmap = new HashMap<>();
        claimmap.put("role", "ADMIN");
        return Jwts.builder()
        .setSubject(userDetails.getUsername())
        .addClaims(claimmap)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60  * 60 * 2))
        .signWith(getKey(),SignatureAlgorithm.HS256)
        .compact();
    }

    public Key getKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }


    public String getUserNameByToken(String token){
        return exportToken(token, Claims::getSubject);
    }


    public boolean isTokenExpired(String token){
        Date expiredTokenDate = exportToken(token, Claims::getExpiration);
        return new Date().before(expiredTokenDate);
    }

    public <T> T exportToken(String token,Function<Claims,T> claimsFunc){
        Claims claims = Jwts.parserBuilder()
        .setSigningKey(getKey())
        .build()
        .parseClaimsJws(token).getBody();

        return claimsFunc.apply(claims);
    }


}
