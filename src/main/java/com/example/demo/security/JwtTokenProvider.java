package com.example.demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;

@Component
public class JwtTokenProvider {

    private final String SECRET_KEY = "my-super-secret-key"; // Change to a strong secret
    private final long EXPIRATION_MS = 3600000; // 1 hour

    public String createToken(Long userId, String email, Set<String> roles) {
        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getEmail(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public Set<String> getRoles(String token) {
        return (Set<String>) Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .get("roles");
    }

    public Long getUserId(String token) {
        return ((Number) Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .get("userId")).longValue();
    }
}
