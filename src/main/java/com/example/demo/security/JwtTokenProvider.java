package com.example.demo.security;

import java.util.HashSet;
import java.util.Set;

public class JwtTokenProvider {

    public JwtTokenProvider() {
    }

    public String createToken(Long userId, String email, Set<String> roles) {
        // Dummy token for testing
        return "dummy-jwt-token-for-" + email;
    }

    public boolean validateToken(String token) {
        // Always valid for dummy security
        return token != null && token.startsWith("dummy-jwt-token");
    }

    public String getEmail(String token) {
        if (token == null) return null;
        return token.replace("dummy-jwt-token-for-", "");
    }

    public Set<String> getRoles(String token) {
        Set<String> roles = new HashSet<>();
        roles.add("USER");
        return roles;
    }

    public Long getUserId(String token) {
        return 1L;
    }
}
