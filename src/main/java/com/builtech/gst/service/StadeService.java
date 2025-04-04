package com.builtech.gst.service;

import com.builtech.gst.dto.StadeDto;
import com.builtech.gst.entity.Stade;
import com.builtech.gst.repository.StadeRepository;
import com.builtech.gst.repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


@Service
public class StadeService {

    private final StadeRepository repository;
    private final UserRepository userRepository;

    public StadeService(StadeRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public Stade create(StadeDto stadeRegister){

        if(ifStadeExistsAtPlace(stadeRegister.getLocation()))
        {
            throw new EntityExistsException("Un stade est localise aux memes coordonnees. Verifier vos informations !");
        }

        Stade stade = new Stade();
        stade.setName(stadeRegister.getName());
        stade.setContact(stadeRegister.getContact());
        stade.setAdresse(stadeRegister.getAdresse());
        stade.setLocation(stadeRegister.getLocation());

        List<byte[]> imagesData = stadeRegister.getImages().stream()
                .map(img -> Base64.getDecoder().decode(img.split(",")[1])) // Supprime le préfixe et décode
                .toList();

        stade.setImages(imagesData);


        return repository.save(stade);
    }

    public Stade update(long stadeId, StadeDto stadeRegister){

        Stade stade = repository.findById(stadeId).orElseThrow(EntityExistsException::new);
        stade.setName(stadeRegister.getName());
        stade.setContact(stadeRegister.getContact());
        stade.setAdresse(stadeRegister.getAdresse());
        stade.setLocation(stadeRegister.getLocation());

        List<byte[]> imagesData = new ArrayList<>();

        if(stadeRegister.getImages().isEmpty()){
            imagesData = null;
        }else{
            imagesData = stadeRegister.getImages().stream()
                    .map(img -> Base64.getDecoder().decode(img.split(",")[1]))
                    .toList();
        }

        stade.setImages(imagesData);

        return repository.save(stade);
    }



    public Stade read(long stadeId){
        Stade stade = repository.findById(stadeId).orElseThrow(EntityNotFoundException::new);
        return stade;
    }

    public String delete(long stadeId){
        Stade stade = repository.findById(stadeId).orElseThrow(EntityNotFoundException::new);
        return "Success";
    }

    public List<Stade> allStades(){
        return repository.findAll();
    }

    public boolean ifStadeExistsAtPlace(String location){
        Stade stade = repository.findByLocalisation(location).orElse(null);
        return stade != null;
    }
}
