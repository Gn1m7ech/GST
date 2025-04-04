package com.builtech.gst.controller;

import com.builtech.gst.dto.UserConnected;
import com.builtech.gst.dto.UserLoginDto;
import com.builtech.gst.dto.UserRegisterDto;
import com.builtech.gst.entity.User;
import com.builtech.gst.service.AuthenticationService;
import com.builtech.gst.utils.JwtUtils;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<User> registerAdmin(@RequestBody @Valid UserRegisterDto user){
        User u = service.signUpAdmin(user);
        return ResponseEntity.ok().body(u);
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody @Valid UserRegisterDto user){
        User u = service.signUpClient(user);
        return ResponseEntity.ok().body(u);
    }

    @PostMapping("/login")
    public ResponseEntity<UserConnected> authenticate(@RequestBody @Valid UserLoginDto user){
        User u = service.authenticate(user);
        String token = jwtUtils.generateToken(u);

        UserConnected ud = new UserConnected();
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
