package com.builtech.gst.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "calendriers")
public class Calendrier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private Date debut;
    @Column(nullable = false)
    private Date fin;
    @Column(nullable = false)
    private String status;

    public Calendrier(long id, Date debut, Date fin, String status) {
        this.id = id;
        this.debut = debut;
        this.fin = fin;
        this.status = status;
    }

    public Calendrier() {
    }

    @ManyToOne(fetch = FetchType.EAGER)
    private Stade stade;

    @ManyToOne(fetch = FetchType.LAZY)
    private Reservation reservation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Stade getStade() {
        return stade;
    }

    public void setStade(Stade stade) {
        this.stade = stade;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
