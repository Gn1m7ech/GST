package com.builtech.gst.dto;

public class UserConnected {

    private String role;
    private String username;
    private long user_id;
    private String token;

    public UserConnected(String token, long user_id, String username, String role) {
        this.token = token;
        this.user_id = user_id;
        this.username = username;
        this.role = role;
    }

    public UserConnected(){}

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
