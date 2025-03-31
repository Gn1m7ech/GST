package com.builtech.gst.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "calendriers")
public class Calendrier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private LocalDate debut;
    @Column(nullable = false)
    private LocalDate fin;
    @Column(nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    private Stade stade;

    @ManyToOne(fetch = FetchType.LAZY)
    private Reservation reservation;

}
