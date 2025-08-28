package com.ali.service.impl;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ali.dto.AuthResponse;
import com.ali.dto.DtoAuthRequest;
import com.ali.dto.DtoUser;
import com.ali.dto.RefreshTokenRequest;
import com.ali.exception.BaseException;
import com.ali.exception.ErrorMessage;
import com.ali.exception.MessageType;
import com.ali.jwt.JwtService;
import com.ali.model.RefreshToken;
import com.ali.model.User;
import com.ali.repository.RefreshTokenRepository;
import com.ali.repository.UserRepository;
import com.ali.service.IAuthService;


@Service
public class AuthServiceImpl implements IAuthService{

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AuthenticationProvider authProvider;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;
 
    private User createUser(DtoAuthRequest inpAuthRequest){
        User user = new User();
        user.setCreateTime(new Date());
        user.setUsername(inpAuthRequest.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(inpAuthRequest.getPassword()));
        return user;
    }

    @Override
    public DtoUser register(DtoAuthRequest input) {
        User user = userRepository.save(createUser(input));
        DtoUser dtoUser = new DtoUser();
        BeanUtils.copyProperties(user, dtoUser);
        
        return dtoUser;
    }
    private RefreshToken createRefreshToken(User user){
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setCreateTime(new Date());
        refreshToken.setExpiredDate(new Date(System.currentTimeMillis() + 1000 * 60*60*4));
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        refreshToken.setUser(user);
        return refreshToken;
    }

    @Override
    public AuthResponse authenticate(DtoAuthRequest input) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(input.getUsername(), input.getPassword());
            authProvider.authenticate(authenticationToken);

            Optional<User> optional = userRepository.findByUsername(input.getUsername());
            
            String accesToken = jwtService.generateToken(optional.get());
            RefreshToken savedRefreshToken= refreshTokenRepository.save(createRefreshToken(optional.get()));
            return new AuthResponse(accesToken,savedRefreshToken.getRefreshToken());
        } catch (Exception e) {
            throw new BaseException(new ErrorMessage(MessageType.USERNAMEORPASSWORDINVALID,e.getMessage()));
        }
    }

    public boolean isValidRefreshToken(Date date){
        return new Date().before(date);
    }

    @Override
    public AuthResponse refreshToken(RefreshTokenRequest refreshToken) {
        Optional<RefreshToken> optional = refreshTokenRepository.findByRefreshToken(refreshToken.getRefreshToken());
        if(optional.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_NOT_FOUND,refreshToken.getRefreshToken()));
        }if(!isValidRefreshToken(optional.get().getExpiredDate())){
            throw new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_IS_EXPIRED,refreshToken.getRefreshToken()));
        }
        User user = optional.get().getUser();
        String accesToken = jwtService.generateToken(user);
        RefreshToken newRefreshToken = refreshTokenRepository.save(createRefreshToken(user));
        return new AuthResponse(accesToken,newRefreshToken.getRefreshToken());

    }

}
