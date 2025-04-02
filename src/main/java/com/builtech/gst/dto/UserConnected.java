package com.builtech.gst.dto;

import lombok.Data;

@Data
public class UserConnected {
    public String username;
    public long user_id;
    public String role;
    public String token;
}
