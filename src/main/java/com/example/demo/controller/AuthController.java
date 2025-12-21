package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth")
public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(UserService userService,
                          JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    // Register new user
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        User user = userService.registerUser(request);
        Map<String, Object> response = new HashMap<>();
        response.put("userId", user.getId());
        response.put("name", user.getName());
        response.put("email", user.getEmail());
        response.put("roles", user.getRoles());
        response.put("createdAt", user.getCreatedAt());
        return ResponseEntity.ok(response);
    }

    // Login and get real JWT token
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        User user = userService.loginUser(request); // Authenticate user
        if (user == null) {
            return ResponseEntity.status(401).body("Invalid email or password");
        }

        // Generate real JWT token
        String token = jwtTokenProvider.createToken(
                user.getId(),
                user.getEmail(),
                user.getRoles()
        );

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("userId", user.getId());
        response.put("email", user.getEmail());
        response.put("roles", user.getRoles());

        return ResponseEntity.ok(response);
    }
}
