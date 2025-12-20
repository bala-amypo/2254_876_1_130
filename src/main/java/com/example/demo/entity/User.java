package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password; // store hashed only

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
        name = "user_roles", 
        joinColumns = @JoinColumn(name = "user_id")
    )
    @Column(name = "role")
    private Set<String> roles = new HashSet<>(Collections.singleton("USER"));

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // One-to-many with FraudAlertRecord
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FraudAlertRecord> fraudAlertRecords = new ArrayList<>();

    // =====================
    // Constructors
    // =====================
    public User() {}

    public User(String name, String email, String password, Set<String> roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        if (roles != null && !roles.isEmpty()) {
            this.roles = roles;
        }
    }

    // =====================
    // PrePersist
    // =====================
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // =====================
    // Getters and Setters
    // =====================
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<FraudAlertRecord> getFraudAlertRecords() {
        return fraudAlertRecords;
    }

    public void setFraudAlertRecords(List<FraudAlertRecord> fraudAlertRecords) {
        this.fraudAlertRecords = fraudAlertRecords;
    }
}
