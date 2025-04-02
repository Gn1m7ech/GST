package com.builtech.gst.dto;

import lombok.Data;

@Data
public class UserRegisterDto {
    private String nom;
    private String email;
    private String password;
    private String contact;
}
