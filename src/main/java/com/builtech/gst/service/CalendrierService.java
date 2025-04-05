package com.builtech.gst.service;

import com.builtech.gst.dto.CalendrierRequest;
import com.builtech.gst.entity.Calendrier;
import com.builtech.gst.repository.CalendrierRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendrierService {

    private final CalendrierRepository repository;

    public CalendrierService(CalendrierRepository repository) {
        this.repository = repository;
    }

    public Calendrier add(CalendrierRequest calendrierRequest){
        Calendrier calendrier = new Calendrier();
        calendrier.setDebut(calendrierRequest.getDebut());
        calendrier.setFin(calendrierRequest.getFin());
        calendrier.setStatus("False");
        return repository.save(calendrier);
    }

    public Calendrier confirm(long calendId){
        Calendrier calendrier = repository.findById(calendId).orElseThrow(EntityNotFoundException::new);
        calendrier.setStatus("True");
        return repository.save(calendrier);
    }

    public String cancel(long calendId){
        Calendrier calendrier = repository.findById(calendId).orElseThrow(EntityNotFoundException::new);
        repository.delete(calendrier);
        return "Success";
    }

    public void delete(long calenId){
        repository.deleteById(calenId);
    }

    public List<Calendrier> getCalendriers(){
        return repository.findAll();
    }

}
