package com.learning.jwt.service;

import com.learning.jwt.models.AuthenticationRequest;
import com.learning.jwt.models.AuthenticationResponse;
import com.learning.jwt.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    AuthenticationResponse authenticationResponse;
    @Autowired
    UserDetails userDetails;

    public AuthenticationResponse authenticateUser (AuthenticationRequest authenticationRequest) throws Exception {
        try {
            userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect Username or Password", e);
        }
        authenticationResponse.setJwt(jwtUtil.generateToken(userDetails));
        return authenticationResponse;
    }

}
