package com.builtech.gst.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "stades")
public class Stade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String adresse;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String contact;

    @ElementCollection
    @Lob
    @JsonIgnore
    private List<byte[]> images;

    @CreationTimestamp()
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;

    @OneToOne
    private User owner;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Reservation> reservations;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Calendrier> calendriers;

}
