package com.builtech.gst.service;

import com.builtech.gst.dto.UserRegister;
import com.builtech.gst.entity.Owner;
import com.builtech.gst.entity.Role;
import com.builtech.gst.repository.OwnerRepository;
import com.builtech.gst.repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {

    private final OwnerRepository repository;
    private final RoleRepository roleRepository;

    public OwnerService(OwnerRepository repository, RoleRepository roleRepository) {
        this.repository = repository;
        this.roleRepository = roleRepository;
    }

    public Owner create(UserRegister user){
        Owner owner = new Owner();
        owner.setNom(user.getNom());
        owner.setContact(user.getContact());
        owner.setEmail(user.getEmail());
        owner.setPassword(user.getPassword());

        Role role = roleRepository.getOwnerRole().orElse(null);
        if (role==null) {
            throw new EntityNotFoundException("Role not found !");
        }

        owner.setRole(role);
        return repository.save(owner);
    }

    public Owner update(long userId, UserRegister user){
        Owner owner = repository.findById(userId).orElse(null);
        if(owner==null){
            throw new EntityNotFoundException("User not found !");
        }
        owner.setNom(user.getNom());
        owner.setEmail(user.getEmail());
        owner.setContact(user.getContact());
        owner.setPassword(user.getPassword());
        return repository.save(owner);
    }

    public Owner read(long userId){
        
        Owner owner = repository.findById(userId).orElse(null);
        if(owner==null){
            throw new EntityNotFoundException("User not found !");
        }
        return owner;
    }

    public String delete(long userId){
        String a = "Success";
        Owner owner = repository.findById(userId).orElse(null);
        if(owner==null)
            throw new EntityNotFoundException("User not found !");
        repository.delete(owner);
        return a;
    }

}
