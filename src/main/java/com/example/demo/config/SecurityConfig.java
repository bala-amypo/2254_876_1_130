package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // Password encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Security filter chain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for testing POST
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/auth/**",                // Login/register
                    "/stolen-devices/**",      // All stolen-device endpoints
                    "/v3/api-docs/**",         // Swagger docs
                    "/swagger-ui/**",
                    "/swagger-ui.html",
                    "/error"                   // Whitelabel page
                ).permitAll()
                .anyRequest().authenticated() // All other endpoints require auth
            );

        return http.build();
    }
}
