package com.application.service.impl;

import com.application.dto.LoginRequest;
import com.application.dto.ForgotPasswordRequest;
import com.application.entity.User;
import com.application.repository.UserRepository;
import com.application.service.AuthService;
import com.application.util.JwtUtil;
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
            .orElseThrow(() -> new RuntimeException("User not found"));
        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return jwtUtil.generateToken(user);
    }

    @Override
    public String forgotPassword(ForgotPasswordRequest request) {
        return "Reset link sent to " + request.getEmail();
    }
}