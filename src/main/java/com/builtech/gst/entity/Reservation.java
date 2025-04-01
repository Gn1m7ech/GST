package com.builtech.gst.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private LocalDate bookedAt;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private long prix;
    @Column(nullable = false)
    private String statut;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client")
    private User client;

    @ManyToOne(fetch = FetchType.EAGER)
    private Stade stade;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Calendrier> calendriers;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Notification> notification;

}
