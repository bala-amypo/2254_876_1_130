package com.example.demo.model;

import java.time.LocalDateTime;

public class User {
    private Long id;
    private String username;
    private String token;
    private LocalDateTime createdAt;

    public void setId(Long id) { this.id = id; }
    public void setUsername(String username) { this.username = username; }
    public void setToken(String token) { this.token = token; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
