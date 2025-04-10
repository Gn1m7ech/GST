package com.builtech.gst.service;

import com.builtech.gst.dto.LoginRequest;
import com.builtech.gst.dto.RegisterRequest;
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

    public User signUpAdmin(RegisterRequest user){
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

    public User signUpClient(RegisterRequest user){
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

    public User signUpOwner(RegisterRequest user){
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

    public User authenticate(LoginRequest user){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );

        return userRepository.findByEmail(user.getUsername())
                .orElseThrow(EntityNotFoundException::new);
    }

    public User setOwner(long userId){
        User user = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
        Role role = roleRepository.getOwnerRole().orElseThrow(EntityNotFoundException::new);
        user.setRole(role);
        return userRepository.save(user);
    }
}
