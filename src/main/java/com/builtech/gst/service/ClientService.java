package com.builtech.gst.service;

import com.builtech.gst.dto.UserRegister;
import com.builtech.gst.entity.Client;
import com.builtech.gst.entity.Role;
import com.builtech.gst.repository.ClientRepository;
import com.builtech.gst.repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository repository;
    private final RoleRepository roleRepository;

    public ClientService(ClientRepository repository, RoleRepository roleRepository) {
        this.repository = repository;
        this.roleRepository = roleRepository;
    }

    public Client create(UserRegister user){
        Client client = new Client();
        client.setNom(user.getNom());
        client.setContact(user.getContact());
        client.setEmail(user.getEmail());
        client.setPassword(user.getPassword());

        Role role = roleRepository.getClientRole().orElse(null);
        if (role==null) {
            throw new EntityNotFoundException("Role not found !");
        }

        client.setRole(role);
        return repository.save(client);
    }

    public Client update(long userId, UserRegister user){
        Client client = repository.findById(userId).orElse(null);
        if(client==null){
            throw new EntityNotFoundException("User not found !");
        }
        client.setNom(user.getNom());
        client.setEmail(user.getEmail());
        client.setContact(user.getContact());
        client.setPassword(user.getPassword());
        return repository.save(client);
    }

    public Client read(long userId){

        Client client = repository.findById(userId).orElse(null);
        if(client==null){
            throw new EntityNotFoundException("User not found !");
        }
        return client;
    }

    public String delete(long userId){
        String a = "Success";
        Client client = repository.findById(userId).orElse(null);
        if(client==null)
            throw new EntityNotFoundException("User not found !");
        repository.delete(client);
        return a;
    }

}
