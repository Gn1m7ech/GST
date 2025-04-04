package com.builtech.gst.service;

import com.builtech.gst.dto.UserRegisterDto;
import com.builtech.gst.entity.Role;
import com.builtech.gst.entity.User;
import com.builtech.gst.repository.RoleRepository;
import com.builtech.gst.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User update(long userId, UserRegisterDto user){
        User user1 = repository.findById(userId).orElse(null);
        if(user1==null){
            throw new EntityNotFoundException("USer not found !");
        }
        user1.setNom(user.getNom());
        user1.setEmail(user.getEmail());
        user1.setContact(user.getContact());
        user1.setPassword(passwordEncoder.encode(user1.getPassword()));

        return repository.save(user1);
    }

    public String delete(long userId){
        User user1 = repository.findById(userId).orElse(null);
        if(user1==null){
            throw new EntityNotFoundException("USer not found !");
        }
        repository.delete(user1);
        return "Success";
    }

    public User read(long userId){
        User user1 = repository.findById(userId).orElse(null);
        if(user1==null){
            throw new EntityNotFoundException("USer not found !");
        }
        return user1;
    }

}
