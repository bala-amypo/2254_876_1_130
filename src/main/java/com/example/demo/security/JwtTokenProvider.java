package com.example.demo.security;

import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

@Component
public class JwtTokenProvider {

    public JwtTokenProvider() {
    }

    // CREATE TOKEN
    public String createToken(Long userId, String email, Set<String> roles) {

        // Simple JWT-like structure (header.payload.signature)
        String header = Base64.getEncoder().encodeToString("header".getBytes());
        String payload = Base64.getEncoder().encodeToString(
                (userId + ":" + email + ":" + String.join(",", roles)).getBytes()
        );
        String signature = "signature";

        return header + "." + payload + "." + signature;
    }

    // VALIDATE TOKEN
    public boolean validateToken(String token) {
        return token != null && token.split("\\.").length == 3;
    }

    // EXTRACT EMAIL
    public String getEmail(String token) {
        String payload = new String(Base64.getDecoder().decode(token.split("\\.")[1]));
        return payload.split(":")[1];
    }

    // EXTRACT ROLES
    public Set<String> getRoles(String token) {
        String payload = new String(Base64.getDecoder().decode(token.split("\\.")[1]));
        String rolesStr = payload.split(":")[2];

        Set<String> roles = new HashSet<>();
        for (String role : rolesStr.split(",")) {
            roles.add(role);
        }
        return roles;
    }

    // EXTRACT USER ID
    public Long getUserId(String token) {
        String payload = new String(Base64.getDecoder().decode(token.split("\\.")[1]));
        return Long.parseLong(payload.split(":")[0]);
    }
}
