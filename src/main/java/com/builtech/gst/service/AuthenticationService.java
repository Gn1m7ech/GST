package com.builtech.gst.service;

import com.builtech.gst.dto.UserLoginDto;
import com.builtech.gst.dto.UserRegisterDto;
import com.builtech.gst.entity.Role;
import com.builtech.gst.entity.User;
import com.builtech.gst.repository.RoleRepository;
import com.builtech.gst.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public User signUpAdmin(UserRegisterDto user){
        Role role = roleRepository.getAdminRole().orElse(null);
        if(role==null){
            throw new EntityNotFoundException("Role not found !");
        }
        User user1 = new User();
        user1.setNom(user.getNom());
        user1.setEmail(user.getEmail());
        user1.setContact(user.getContact());
        user1.setPassword(passwordEncoder.encode(user.getPassword()));
        user1.setRole(role);

        return userRepository.save(user1);
    }

    public User signUpClient(UserRegisterDto user){
        Role role = roleRepository.getClientRole().orElse(null);
        if(role==null){
            throw new EntityNotFoundException("Role not found !");
        }
        User user1 = new User();
        user1.setNom(user.getNom());
        user1.setEmail(user.getEmail());
        user1.setContact(user.getContact());
        user1.setPassword(passwordEncoder.encode(user.getPassword()));
        user1.setRole(role);

        return userRepository.save(user1);
    }

    public User signUpOwner(UserRegisterDto user){
        Role role = roleRepository.getOwnerRole().orElse(null);
        if(role==null){
            throw new EntityNotFoundException("Role not found !");
        }
        User user1 = new User();
        user1.setNom(user.getNom());
        user1.setEmail(user.getEmail());
        user1.setContact(user.getContact());
        user1.setPassword(passwordEncoder.encode(user.getPassword()));
        user1.setRole(role);

        return userRepository.save(user1);
    }

    public User authenticate(UserLoginDto user){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );

        return userRepository.findByEmail(user.getUsername())
                .orElseThrow(EntityNotFoundException::new);
    }
}
