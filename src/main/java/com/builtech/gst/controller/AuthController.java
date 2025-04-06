package com.builtech.gst.controller;

import com.builtech.gst.dto.*;
import com.builtech.gst.entity.User;
import com.builtech.gst.mapper.UserMapper;
import com.builtech.gst.service.AuthenticationService;
import com.builtech.gst.utils.JwtUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;

@RestController
@RequestMapping("/gst/auth")
public class AuthController {

    private final JwtUtils jwtUtils;
    private final AuthenticationService service;
    private final UserMapper mapper;

    public AuthController(JwtUtils jwtUtils, AuthenticationService service, UserMapper mapper) {
        this.jwtUtils = jwtUtils;
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/signup-ad")
    public ResponseEntity<?> registerAdmin(@RequestBody @Validated RegisterRequest user){
        if(user.getNom().isEmpty()||
                user.getEmail().isEmpty()||
                user.getPassword().isEmpty()||
                user.getContact().isEmpty()){
            return ResponseEntity.badRequest().body(new ApiResponse(1,"un ou plusieurs valeurs sont nuls !"));
        }
        User u = service.signUpAdmin(user);
        return ResponseEntity.ok().body(mapper.INSTANCE.userToUserDto(u));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody @Validated RegisterRequest user){
        if(user.getNom().isEmpty()||
                user.getEmail().isEmpty()||
                user.getPassword().isEmpty()||
                user.getContact().isEmpty()){
            return ResponseEntity.badRequest().body(new ApiResponse(1,"un ou plusieurs valeurs sont nuls !"));
        }
        User u = service.signUpClient(user);
        return ResponseEntity.ok().body(mapper.INSTANCE.userToUserDto(u));
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody @Validated LoginRequest user){
        if(user.getUsername().isEmpty()||
                user.getPassword().isEmpty()){
            return ResponseEntity.badRequest().body(new ApiResponse(1,"un ou plusieurs valeurs sont nuls !"));
        }
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
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserDto> setOwner(@PathVariable long userId){
        return ResponseEntity.ok().body(mapper.INSTANCE.userToUserDto(service.setOwner(userId)));
    }

}
