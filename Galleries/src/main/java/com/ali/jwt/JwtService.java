package com.ali.jwt;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    public static final String SECRET_KEY="axnv7BBqu8cPPb4Noyjgc2lm6BN466eePnMfHr8p+Sw=";

    public String generateToken(UserDetails userDetails){
        return Jwts.builder()
            .setSubject(userDetails.getUsername())
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 1000 *60*60*2))
            .signWith(getKey(),SignatureAlgorithm.HS256)
            .compact();
    }


    public String getUserNAmeByToken(String token){
        return exportToken(token, Claims::getSubject);
    }

    public boolean isTokenValid(String token){
        Date expiredDate = exportToken(token, Claims::getExpiration));
        return new Date().before(expiredDate);
    }


    public <T> T exportToken(String token, Function<Claims,T> claFunction){
        Claims claims = getClaims(token);
        return claFunction.apply(claims);
    }


    public Claims getClaims(String token){
        Claims claims = Jwts.parserBuilder()
        .setSigningKey(getKey())
        .build()
        .parseClaimsJws(token).getBody();

        return claims;
    }

    public Key getKey(){
        byte[] bytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(bytes);
    }
}
