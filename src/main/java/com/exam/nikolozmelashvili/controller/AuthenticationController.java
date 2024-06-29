package com.exam.nikolozmelashvili.controller;

import com.exam.nikolozmelashvili.entities.dto.request.AuthenticationRequest;
import com.exam.nikolozmelashvili.entities.dto.request.RegisterRequest;
import com.exam.nikolozmelashvili.entities.dto.response.AuthenticationResponse;
import com.exam.nikolozmelashvili.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/rest/authentication")
public class AuthenticationController {

    private AuthenticationService service;

    @Autowired
    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.service = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return new ResponseEntity<>(service.register(request), HttpStatus.OK);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request)
            throws AuthenticationException {
        return new ResponseEntity<>(service.authenticate(request), HttpStatus.OK);
    }
}
