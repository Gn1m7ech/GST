package com.builtech.gst.controller;

import com.builtech.gst.dto.UserConnected;
import com.builtech.gst.dto.UserLoginDto;
import com.builtech.gst.dto.UserRegisterDto;
import com.builtech.gst.entity.User;
import com.builtech.gst.service.AuthenticationService;
import com.builtech.gst.utils.JwtUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtils jwtUtils;
    private final AuthenticationService service;

    public AuthController(JwtUtils jwtUtils, AuthenticationService service) {
        this.jwtUtils = jwtUtils;
        this.service = service;
    }

    @PostMapping("/signup-ad")
    public ResponseEntity<User> registerAdmin(@RequestBody UserRegisterDto user){
        User u = service.signUpAdmin(user);
        return ResponseEntity.ok().body(u);
    }

    @PostMapping("/signup-cli")
    public ResponseEntity<User> registerClient(@RequestBody UserRegisterDto user){
        User u = service.signUpClient(user);
        return ResponseEntity.ok().body(u);
    }

//    public ResponseEntity<User> registerAdmin(@RequestBody UserRegisterDto user){
//
//    }

    @PostMapping("/login")
    public ResponseEntity<UserConnected> authenticate(@RequestBody UserLoginDto user){
        User u = service.authenticate(user);
        String token = jwtUtils.generateToken(u);

        UserConnected ud = new UserConnected(token,u.getId(), user.getUsername(), u.getRole().getRole());
        return ResponseEntity.ok().body(ud);
    }
}
