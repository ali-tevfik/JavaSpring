package com.example.service.Impl;

import java.util.Optional;

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
import com.example.repository.UserRepository;
import com.example.service.IAuthService;


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

    @Override
    public AuthResponse authenticate(AuthRequest authRequest) {
            System.out.println("Amcik11");
        
        try {
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
            System.out.println("Amcik13{" + authRequest.getUsername()+"}{"+authRequest.getPassword()+"}");
            authenticationProvider.authenticate(auth);
            System.out.println("Amcik1");
            Optional<User> user = userRepository.findByUsername(authRequest.getUsername());
            System.out.println("Amcik2");
            String token = jwtService.generateToken(user.get());
            return new AuthResponse(token);
        } catch (Exception e) {
            System.err.println("Incorrect username or pass");
        }
        return null;
    }

}
