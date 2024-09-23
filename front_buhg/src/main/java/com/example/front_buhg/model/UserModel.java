package com.example.front_buhg.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "t_user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @ElementCollection(targetClass = RoleEnum.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)

    private Set<RoleEnum> role;

    public UserModel(String username, String password, Set<RoleEnum> role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public UserModel() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RoleEnum> getRole() {
        return role;
    }

    public void setRole(Set<RoleEnum> role) {
        this.role = role;
    }
}
