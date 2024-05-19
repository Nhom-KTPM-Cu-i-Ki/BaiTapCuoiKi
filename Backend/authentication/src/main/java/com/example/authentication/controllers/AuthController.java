package com.example.authentication.controllers;


import com.example.authentication.dto.AuthRequest;
import com.example.authentication.entities.UserCredential;
import com.example.authentication.service.AuthService;
import com.example.authentication.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService service;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String addNewUser(@RequestBody  UserCredential user) {
        return service.saveUser(user);
    }

    @GetMapping("/student")
    @PreAuthorize("hasAuthority('ROLE_STUDENT')")
    public String studentTest() {
        return "User has role student";
    }
    @GetMapping("/intrustor")
    @PreAuthorize("hasAuthority('ROLE_INTRUSTOR')")
    public String intrustorTest() {
        return "User has role intrustor";
    }

    @PostMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest) {

        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        }else {
            throw new RuntimeException("Invalid access");
        }

    }

}
