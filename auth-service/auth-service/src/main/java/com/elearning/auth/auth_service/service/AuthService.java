package com.elearning.auth.auth_service.service;

import com.elearning.auth.auth_service.dto.LoginRequest;
import com.elearning.auth.auth_service.dto.LoginResponse;
import com.elearning.auth.auth_service.dto.RegisterResponse;

public interface AuthService {
    RegisterResponse register(LoginRequest request);
    LoginResponse login(LoginRequest request);
}
