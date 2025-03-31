package com.builtech.gst.service;

import com.builtech.gst.dto.UserRegister;
import com.builtech.gst.entity.Admin;
import com.builtech.gst.entity.Role;
import com.builtech.gst.repository.AdminRepository;
import com.builtech.gst.repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final AdminRepository repository;
    private final RoleRepository roleRepository;

    public AdminService(AdminRepository repository, RoleRepository roleRepository) {
        this.repository = repository;
        this.roleRepository = roleRepository;
    }

    public Admin create(UserRegister user){
        Admin admin = new Admin();
        admin.setNom(user.getNom());
        admin.setContact(user.getContact());
        admin.setEmail(user.getEmail());
        admin.setPassword(user.getPassword());

        Role role = roleRepository.getAdminRole().orElse(null);
        if (role==null) {
            throw new EntityNotFoundException("Role not found !");
        }

        admin.setRole(role);
        return repository.save(admin);
    }

    public Admin update(long userId, UserRegister user){
        Admin admin = repository.findById(userId).orElse(null);
        if(admin==null){
            throw new EntityNotFoundException("User not found !");
        }
        admin.setNom(user.getNom());
        admin.setEmail(user.getEmail());
        admin.setContact(user.getContact());
        admin.setPassword(user.getPassword());
        return repository.save(admin);
    }

    public Admin read(long userId){

        Admin admin = repository.findById(userId).orElse(null);
        if(admin==null){
            throw new EntityNotFoundException("User not found !");
        }
        return admin;
    }

    public String delete(long userId){
        String a = "Success";
        Admin admin = repository.findById(userId).orElse(null);
        if(admin==null)
            throw new EntityNotFoundException("User not found !");
        repository.delete(admin);
        return a;
    }

}
