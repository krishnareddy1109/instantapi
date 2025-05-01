package com.application.service;

import com.application.dto.LoginRequest;
import com.application.dto.ForgotPasswordRequest;

public interface AuthService {
    String login(LoginRequest request);
    String forgotPassword(ForgotPasswordRequest request);
}