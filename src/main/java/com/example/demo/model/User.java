package com.example.demo.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String email;
    
    private String password;
    private String name;
    
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<String> roles = new HashSet<>();
    
    public User() {}
    
    public static UserBuilder builder() {
        return new UserBuilder();
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public Set<String> getRoles() { return roles; }
    public void setRoles(Set<String> roles) { this.roles = roles; }
    
    public static class UserBuilder {
        private User user = new User();
        
        public UserBuilder id(Long id) { user.setId(id); return this; }
        public UserBuilder email(String email) { user.setEmail(email); return this; }
        public UserBuilder password(String password) { user.setPassword(password); return this; }
        public UserBuilder name(String name) { user.setName(name); return this; }
        public UserBuilder roles(Set<String> roles) { user.setRoles(roles); return this; }
        
        public User build() { return user; }
    }
}