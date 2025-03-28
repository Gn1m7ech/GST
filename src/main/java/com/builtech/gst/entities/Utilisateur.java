package com.builtech.gst.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "users")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String contact;
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDate createdAt;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDate updatedAt;

    @OneToOne
    private Role role;

}
