package com.builtech.gst.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private Date notifiedAt;
    @Column(nullable = false)
    private String objet;
    @Column(nullable = false)
    private String message;
    @Column(nullable = false)
    private String status;

    public Notification(long id, Date notifiedAt, String objet, String message, String status) {
        this.id = id;
        this.notifiedAt = notifiedAt;
        this.objet = objet;
        this.message = message;
        this.status = status;
    }

    public Notification(){}

    @ManyToOne(fetch = FetchType.EAGER)
    private Reservation reservation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getNotifiedAt() {
        return notifiedAt;
    }

    public void setNotifiedAt(Date notifiedAt) {
        this.notifiedAt = notifiedAt;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
