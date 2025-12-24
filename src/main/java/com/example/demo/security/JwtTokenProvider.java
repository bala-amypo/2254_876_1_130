package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class JwtTokenProvider {

    private final String secretKey = "secret-key-demo";
    private final long validityInMs = 3600000;

    // ✅ REQUIRED BY TESTS
    public String createToken(Long userId, String email, Set<String> roles) {
        Claims claims = Jwts.claims().setSubject(email);
        claims.put("userId", userId);
        claims.put("roles", roles);

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMs);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // ✅ TEST CALLS THIS
    public String getEmail(String token) {
        return extractAllClaims(token).getSubject();
    }

    // ✅ TEST CALLS THIS
    @SuppressWarnings("unchecked")
    public Set<String> getRoles(String token) {
        return new HashSet<>(
                (List<String>) extractAllClaims(token).get("roles")
        );
    }

    // ✅ REQUIRED BY FILTER
    public boolean validateToken(String token) {
        try {
            return !extractAllClaims(token)
                    .getExpiration()
                    .before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    // 🔒 INTERNAL
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }
}
