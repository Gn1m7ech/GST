package com.builtech.gst.controller;

import com.builtech.gst.dto.ReservationDto;
import com.builtech.gst.dto.ReservationRequest;
import com.builtech.gst.entity.Reservation;
import com.builtech.gst.mapper.ReservationMapper;
import com.builtech.gst.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gst/book")
public class ReservationController {

    private final ReservationService service;
    private final ReservationMapper mapper;

    public ReservationController(ReservationService service, ReservationMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/new")
    @PreAuthorize("hasRole('CLIENT')")
    public ResponseEntity<ReservationDto> add(@RequestBody @Validated ReservationRequest dto){
        return ResponseEntity.ok(mapper.INSTANCE.reservationToDto(service.reserver(dto)));
    }

    @PutMapping("/ok")
    @PreAuthorize("hasRole('OWNER')")
    public ResponseEntity<ReservationDto> valider(@RequestParam long reservId){
        return ResponseEntity.ok(mapper.INSTANCE.reservationToDto(service.valider(reservId)));
    }

    @PutMapping("/no")
    @PreAuthorize("hasRole('OWNER')")
    public ResponseEntity<String> cancel(@RequestParam long reservId){
        return ResponseEntity.ok(service.cancel(reservId));
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAnyRole('ADMIN','OWNER')")
    public ResponseEntity<String> supprimer(@RequestParam long reservId){
        return ResponseEntity.ok(service.supprimer(reservId));
    }

}
