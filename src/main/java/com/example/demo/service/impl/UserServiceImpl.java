package com.example.demo.service.impl;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already in use");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());

        // ✅ PASSWORD ENCODING (CRITICAL FIX)
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        if (request.getRoles() == null || request.getRoles().isEmpty()) {
            user.setRoles(Set.of("USER"));
        } else {
            user.setRoles(request.getRoles());
        }

        return userRepository.save(user);
    }

    @Override
    public User loginUser(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        // ✅ CORRECT PASSWORD CHECK
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        return user;
    }
}
