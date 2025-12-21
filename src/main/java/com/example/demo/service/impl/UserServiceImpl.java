package com.example.demo.service.impl;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    // RULE: Constructor order must be exactly this
    public UserServiceImpl(UserRepository userRepository, 
                          PasswordEncoder passwordEncoder, 
                          JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public User registerUser(RegisterRequest request) {
        // RULE: Check duplicate email and use specific keyword
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already in use");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        // RULE: Password must be hashed
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRoles(request.getRoles());

        return userRepository.save(user);
    }
    
    // implement other methods (loginUser, etc.)
}