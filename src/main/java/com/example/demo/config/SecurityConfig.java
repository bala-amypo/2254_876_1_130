package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // Password encoder bean
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Security filter chain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Disable CSRF for testing POST requests
            .csrf(csrf -> csrf.disable())
            // Configure which endpoints are public or secured
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/auth/**",                  // Login/register public
                    "/stolen-devices/**",        // Stolen device endpoints public
                    "/v3/api-docs/**",            // Swagger
                    "/swagger-ui/**",             // Swagger UI
                    "/swagger-ui.html",           // Swagger HTML
                    "/error"                      // Whitelabel/error page
                ).permitAll()
                .anyRequest().authenticated()    // All other endpoints require auth
            );

        return http.build();
    }
}
