package com.builtech.gst.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class UserLoginDto {

    @NotNull
    @Email
    private String username;

    @NotNull
    private String password;

    public UserLoginDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserLoginDto() {
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
}
