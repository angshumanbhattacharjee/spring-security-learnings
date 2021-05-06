package com.learning.jwt.controller;

import com.learning.jwt.models.AuthenticationRequest;
import com.learning.jwt.models.AuthenticationResponse;
import com.learning.jwt.service.AuthenticationService;
import com.learning.jwt.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    AuthenticationService authenticationService;

    @GetMapping("/hello")
    public String Hello() {
        return "Hello and welcome to this auspicious occasion";
    }

    @PostMapping(value = "/authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthenticationResponse> authenticate (@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect Username or Password", e);
        }

        final AuthenticationResponse authenticationResponse = authenticationService.authenticateUser(authenticationRequest);

        return ResponseEntity.ok(authenticationResponse);
    }
}
