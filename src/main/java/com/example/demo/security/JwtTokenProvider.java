package com.example.demo.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration-ms}")
    private long validityInMilliseconds;

    public String createToken(Long userId, String email, Set<String> roles) {
        Claims claims = Jwts.claims().setSubject(email);
        claims.put("roles", roles);
        claims.put("userId", userId);

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
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException ex) {
            return false;
        }
    }

    public String getEmail(String token) {
        return Jwts.parser().setSigningKey(secretKey)
                .parseClaimsJws(token).getBody().getSubject();
    }

    public Long getUserId(String token) {
        return ((Number) Jwts.parser().setSigningKey(secretKey)
                .parseClaimsJws(token).getBody().get("userId")).longValue();
    }

    @SuppressWarnings("unchecked")
    public Set<String> getRoles(String token) {
        return ((Set<?>) Jwts.parser().setSigningKey(secretKey)
                .parseClaimsJws(token).getBody().get("roles")).stream()
                .map(Object::toString).collect(Collectors.toSet());
    }
}
