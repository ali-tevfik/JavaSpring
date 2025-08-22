package com.example.service.Impl;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.dto.DtoUser;
import com.example.jwt.AuthRequest;
import com.example.jwt.AuthResponse;
import com.example.jwt.JwtService;
import com.example.repository.RefreshTokenRepository;
import com.example.repository.UserRepository;
import com.example.service.IAuthService;
import com.example.model.RefreshToken;
import com.example.model.User;

@Service
public class AuthServiceImpl implements IAuthService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public DtoUser register(AuthRequest request) {

        DtoUser dtoUser = new DtoUser();

        User user =new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        User savedUser = userRepository.save(user);

        BeanUtils.copyProperties(savedUser, dtoUser);
        return dtoUser;
    }

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    private RefreshToken createRefreshToken(User user){
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        refreshToken.setExpiredDate(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 4));
        refreshToken.setUser(user);
        return refreshToken;
    }

    @Override
    public AuthResponse authenticate(AuthRequest authRequest) {
        
        try {
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
            authenticationProvider.authenticate(auth);
            Optional<User> user = userRepository.findByUsername(authRequest.getUsername());
            String accesToken = jwtService.generateToken(user.get());
            RefreshToken refreshToken = createRefreshToken(user. get());
            refreshTokenRepository.save(refreshToken);

            return new AuthResponse(accesToken,refreshToken.getRefreshToken());
        } catch (Exception e) {
            System.err.println("Incorrect username or pass");
        }
        return null;
    }

}
