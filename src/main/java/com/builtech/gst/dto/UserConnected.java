package com.builtech.gst.dto;




public class UserConnected {

    public String username;
    public long userId;
    public String role;
    public String token;

    public UserConnected(String username, long userId, String role, String token) {
        this.username = username;
        this.userId = userId;
        this.role = role;
        this.token = token;
    }

    public UserConnected() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
