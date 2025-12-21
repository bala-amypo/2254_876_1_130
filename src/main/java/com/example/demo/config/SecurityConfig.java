package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

   @Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable())  // Disable CSRF for testing POST requests
        .authorizeHttpRequests(auth -> auth
            .requestMatchers(
                "/auth/**",                  // Allow login/register
                "/stolen-devices/**",         // ⭐ Allow all stolen device endpoints
                "/v3/api-docs/**", 
                "/swagger-ui/**", 
                "/swagger-ui.html", 
                "/error"                      // Allow Whitelabel page
            ).permitAll()
            .anyRequest().authenticated()     // Everything else requires auth
        );

    return http.build();
}
