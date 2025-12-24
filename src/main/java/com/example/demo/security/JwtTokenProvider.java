package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

@Component
public class JwtTokenProvider {

    // simple static secret for tests
    private final String secretKey = "test-secret-key";

    // token validity: 1 hour
    private final long validityInMilliseconds = 3600000;

    public String createToken(Long userId, String email, Set<String> roles) {

        Claims claims = Jwts.claims().setSubject(email);
        claims.put("userId", userId);
        claims.put("roles", roles);

        Date now = new Date();
        Date expiry = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            extractAllClaims(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public String getEmail(String token) {
        return extractAllClaims(token).getSubject();
    }

    @SuppressWarnings("unchecked")
    public Set<String> getRoles(String token) {
        return new HashSet<>(
                (List<String>) extractAllClaims(token).get("roles")
        );
    }

    public Long getUserId(String token) {
        Object id = extractAllClaims(token).get("userId");
        return id == null ? null : Long.valueOf(id.toString());
    }

    // ===== REQUIRED PRIVATE HELPER =====
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }
}
