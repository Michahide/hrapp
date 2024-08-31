package com.hrdku.user.users;

import java.io.Serializable;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity

public class Users implements Serializable {
    // private static final long serialVersionUID = 1L;
    @Id
    private int id;

    @Column(length = 50)
    @NotEmpty(message = "Name is required")
    private String name;

    @Column(length = 50)
    @NotEmpty(message = "Email is required")
    private String email;

    @Column(length = 50)
    @NotEmpty(message = "Password is required")
    private String password;

    @Column(length = 50)
    private String role;

    @Column(length = 50)
    private String status;

    @CreationTimestamp
    private Timestamp created_at;

    @UpdateTimestamp
    private Timestamp updated_at;
    private Timestamp deleted_at;
    
    public Users() {
        super();
    }
    
    public Users(int id, @NotEmpty(message="Name is required") String name, @NotEmpty(message="Email is required") String email, @NotEmpty(message="Password is required") String password,  String role, String status, Timestamp created_at, Timestamp updated_at, Timestamp deleted_at) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public Timestamp getCreated_at() {
        return created_at;
    }
    
    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
    
    public Timestamp getUpdated_at() {
        return updated_at;
    }
    
    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
    
    public Timestamp getDeleted_at() {
        return deleted_at;
    }
    
    public void setDeleted_at(Timestamp deleted_at) {
        this.deleted_at = deleted_at;
    }
    
    @Override
    public String toString() {
        return "Users [name=" + name + ", email=" + email + ", password=" + password + ", role=" + role + ", status=" + status + ", created_at=" + created_at + ", updated_at=" + updated_at + ", deleted_at=" + deleted_at + "]";
    }

}
