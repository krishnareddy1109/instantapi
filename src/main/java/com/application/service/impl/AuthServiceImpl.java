package com.application.service.impl;

import com.application.dto.ForgotPasswordRequest;
import com.application.dto.LoginRequest;
import com.application.entity.User;
import com.application.repository.UserRepository;
import com.application.service.AuthService;
import com.application.util.JwtUtil;
import com.application.exception.InstantAppExceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public String login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new InstantAppExceptions.InvalidCredentialsException("Invalid email or password"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new InstantAppExceptions.InvalidCredentialsException("Invalid email or password");
        }

        return jwtUtil.generateToken(user);
    }

    @Override
    public String forgotPassword(ForgotPasswordRequest request) {
        Optional<User> userOpt = userRepository.findByEmail(request.getEmail());

        if (userOpt.isEmpty()) {
            throw new InstantAppExceptions.BadRequestException("Email address not found. Please check and try again.");
        }

        // In real applications, send email with secure token here
        return "Reset link sent to " + request.getEmail();
    }
}
