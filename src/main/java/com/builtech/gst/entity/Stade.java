package com.builtech.gst.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "stadiums")
public class Stade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String adresse;
    @Column(nullable = false)
    private Set<String> locateAt;
    @Column(nullable = false)
    private String contact;
    private List<String> imageUrls;
    @CreationTimestamp
    private LocalDate createdAt;
    @UpdateTimestamp
    private LocalDate updatedAt;

    @OneToOne(mappedBy = "stade")
    private Owner owner;

    @OneToMany(mappedBy = "stade", fetch = FetchType.LAZY)
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "stade", fetch = FetchType.LAZY)
    private List<Calendrier> calendriers;

}
