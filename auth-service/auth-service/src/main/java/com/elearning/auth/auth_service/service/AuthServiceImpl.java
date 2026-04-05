package com.elearning.auth.auth_service.service;

import com.elearning.notification.notification_service.dto.NotificationDTO;
import com.elearning.auth.auth_service.config.JwtUtil;
import com.elearning.auth.auth_service.dto.LoginRequest;
import com.elearning.auth.auth_service.dto.LoginResponse;
import com.elearning.auth.auth_service.dto.RegisterResponse;
import com.elearning.auth.auth_service.entity.User;
import com.elearning.auth.auth_service.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private final RabbitTemplate rabbitTemplate;

    public AuthServiceImpl(UserRepository userRepository, JwtUtil jwtUtil,RabbitTemplate rabbitTemplate) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public RegisterResponse register(LoginRequest request) {
        if (userRepository.findByEmail(request.email()).isPresent())
            return new RegisterResponse("User already exists");

        User user = new User();
        user.setEmail(request.email());
        user.setPassword(encoder.encode(request.password()));
        user.setRole("STUDENT");
        userRepository.save(user);

        // Publier événement vers RabbitMQ
        rabbitTemplate.convertAndSend(
                "elearning-exchange",
                "user.created",
                new NotificationDTO("Nouvel utilisateur créé : " + user.getEmail())
        );

        return new RegisterResponse("User registered successfully");
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(request.password(), user.getPassword()))
            throw new RuntimeException("Invalid credentials");

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole());

        return new LoginResponse(token);
    }
}