package com.example.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.jwt.AuthEntryPoint;
import com.example.jwt.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    public static final String AUTHENTICATE = "/authenticate";
    public static final String REGISTER = "/register";

    @Autowired
    private AuthenticationProvider authProvider;

    @Autowired
    private JwtAuthenticationFilter JwtAuthenticationFilter;

    @Autowired
    private AuthEntryPoint authEntryPoint;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
        http.csrf().disable()
        .authorizeHttpRequests(request ->request.requestMatchers(AUTHENTICATE,REGISTER)
        .permitAll()
        .anyRequest()
        .authenticated())
        .exceptionHandling().authenticationEntryPoint(authEntryPoint).and()
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authenticationProvider(authProvider)
        .addFilterAfter(JwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        
        return http.build();
    }
}
