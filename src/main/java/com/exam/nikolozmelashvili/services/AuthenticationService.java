package com.exam.nikolozmelashvili.services;

import com.exam.nikolozmelashvili.entities.base.Role;
import com.exam.nikolozmelashvili.entities.dto.request.AuthenticationRequest;
import com.exam.nikolozmelashvili.entities.dto.request.RegisterRequest;
import com.exam.nikolozmelashvili.entities.dto.response.AuthenticationResponse;
import com.exam.nikolozmelashvili.entities.model.User;
import com.exam.nikolozmelashvili.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var token = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) throws AuthenticationException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        var user = userRepository.findByEmail(request.getEmail());
        if (user == null) {
            throw new UsernameNotFoundException("Invalid email or password");
        }

        var token = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }


}
