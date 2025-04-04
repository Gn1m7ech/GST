package com.builtech.gst.controller;

import com.builtech.gst.dto.ReservationDto;
import com.builtech.gst.entity.Reservation;
import com.builtech.gst.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gst/book")
public class ReservationController {

    private final ReservationService service;

    public ReservationController(ReservationService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<Reservation> add(@RequestBody @Valid ReservationDto dto){
        return ResponseEntity.ok(service.reserver(dto));
    }

    @PutMapping("/ok")
    public ResponseEntity<Reservation> valider(@RequestParam long reservId){
        return ResponseEntity.ok(service.valider(reservId));
    }

    @PutMapping("/no")
    public ResponseEntity<String> cancel(@RequestParam long reserId){
        return ResponseEntity.ok(service.cancel(reserId));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> supprimer(@RequestParam long reserId){
        return ResponseEntity.ok(service.supprimer(reserId));
    }

}
