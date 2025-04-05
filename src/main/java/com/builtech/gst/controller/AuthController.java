package com.builtech.gst.controller;

import com.builtech.gst.dto.AuthResponse;
import com.builtech.gst.dto.LoginRequest;
import com.builtech.gst.dto.RegisterRequest;
import com.builtech.gst.entity.User;
import com.builtech.gst.service.AuthenticationService;
import com.builtech.gst.utils.JwtUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gst/auth")
public class AuthController {

    private final JwtUtils jwtUtils;
    private final AuthenticationService service;

    public AuthController(JwtUtils jwtUtils, AuthenticationService service) {
        this.jwtUtils = jwtUtils;
        this.service = service;
    }

    @PostMapping("/signup-ad")
    public ResponseEntity<User> registerAdmin(@RequestBody @Validated RegisterRequest user){
        User u = service.signUpAdmin(user);
        return ResponseEntity.ok().body(u);
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody @Validated RegisterRequest user){
        User u = service.signUpClient(user);
        return ResponseEntity.ok().body(u);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody @Validated LoginRequest user){
        User u = service.authenticate(user);
        String token = jwtUtils.generateToken(u);

        AuthResponse ud = new AuthResponse();
        ud.setUsername(u.getUsername());
        ud.setUserId(u.getId());
        ud.setToken(token);
        ud.setRole(u.getRole().getRole());

        return ResponseEntity.ok().body(ud);
    }

    @PostMapping("/own/{userId}")
    public ResponseEntity<User> setOwner(@PathVariable long userId){
        return ResponseEntity.ok().body(service.setOwner(userId));
    }

}
