package com.builtech.gst.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserDto {

    private String username;
    private String role;
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date createdAt;

    public UserDto(String username, String role, Date createdAt) {
        this.username = username;
        this.role = role;
        this.createdAt = createdAt;
    }

    public UserDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
