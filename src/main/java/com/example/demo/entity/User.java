package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.Set;

public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Set<String> roles;
    private String token;
    private LocalDateTime createdAt;

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public Set<String> getRoles() { return roles; }
    public String getToken() { return token; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setRoles(Set<String> roles) { this.roles = roles; }
    public void setToken(String token) { this.token = token; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
