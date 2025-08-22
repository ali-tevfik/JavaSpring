package com.example.repository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.RefreshToken;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Long>{
    Optional<RefreshToken> findByRefreshToken(String refreshToken);
}
