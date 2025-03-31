package com.builtech.gst.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private LocalDate notifiedAt;
    @Column(nullable = false)
    private String objet;
    @Column(nullable = false)
    private String message;
    @Column(nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    private Reservation reservation;

}
