package com.builtech.gst.service;

import com.builtech.gst.dto.CalendrierDto;
import com.builtech.gst.dto.ReservationDto;
import com.builtech.gst.entity.Calendrier;
import com.builtech.gst.entity.Reservation;
import com.builtech.gst.entity.Stade;
import com.builtech.gst.entity.User;
import com.builtech.gst.repository.ReservationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;


import java.time.Instant;
import java.util.Date;
import java.util.List;


@Service
public class ReservationService {

    private final ReservationRepository repository;
    private final CalendrierService calendrierService;
    private final UserService userService;
    private final StadeService stadeService;

    public ReservationService(ReservationRepository repository, CalendrierService calendrierService, UserService userService, StadeService stadeService) {
        this.repository = repository;
        this.calendrierService = calendrierService;
        this.userService = userService;
        this.stadeService = stadeService;
    }

    public Reservation reserver(ReservationDto dto){

        Stade stade = stadeService.read(dto.getStade());
        User client = userService.read(dto.getClient());

        Reservation reservation = new Reservation();
        reservation.setBookedAt(Date.from(Instant.now()));
        reservation.setStade(stade);
        reservation.setClient(client);
        reservation.setStatut("Pending");

        List<CalendrierDto> c = dto.getCalendDtos();
        int size = c.size();

        if(size>1){
            reservation.setType("Multiple");
            reservation.setPrix(size*15000);
        }else{
            reservation.setType("Simple");
            reservation.setPrix(15000);
        }

        List<Calendrier> calendriers = c.stream()
                .map(calendrierDto -> calendrierService.add(calendrierDto))
                .toList();

        reservation.setCalendriers(calendriers);
        return repository.save(reservation);
    }

    public String supprimer(long reservId){
        Reservation reservation = repository.findById(reservId).orElseThrow(EntityNotFoundException::new);
        repository.delete(reservation);
        return "Success";
    }

    public Reservation valider(long reservId){
        Reservation reservation = repository.findById(reservId).orElseThrow(EntityNotFoundException::new);
        List<Calendrier> calendriers = reservation.getCalendriers();
        calendriers = calendriers.stream().map(
                calendrier -> calendrierService.confirm(calendrier.getId())
        ).toList();
        reservation.setStatut("Valid");
        return repository.save(reservation);
    }

    public String cancel(long reservId){
        Reservation reservation = repository.findById(reservId).orElseThrow(EntityNotFoundException::new);
        List<Calendrier> calendriers = reservation.getCalendriers();
        for (int i = 0; i < calendriers.size()-1; i++) {
            Calendrier c = calendriers.get(i);
            calendrierService.delete(c.getId());
        }
        reservation.setStatut("Deleted");
        return "Archived";
    }

}

