package com.builtech.gst.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private Date bookedAt;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private long prix;
    @Column(nullable = false)
    private String statut;

    public Reservation(long id, Date bookedAt, String type, long prix, String statut) {
        this.id = id;
        this.bookedAt = bookedAt;
        this.type = type;
        this.prix = prix;
        this.statut = statut;
    }

    public Reservation() {
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client")
    private User client;

    @ManyToOne(fetch = FetchType.EAGER)
    private Stade stade;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Calendrier> calendriers;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Notification> notification;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getBookedAt() {
        return bookedAt;
    }

    public void setBookedAt(Date bookedAt) {
        this.bookedAt = bookedAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getPrix() {
        return prix;
    }

    public void setPrix(long prix) {
        this.prix = prix;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Stade getStade() {
        return stade;
    }

    public void setStade(Stade stade) {
        this.stade = stade;
    }

    public List<Calendrier> getCalendriers() {
        return calendriers;
    }

    public void setCalendriers(List<Calendrier> calendriers) {
        this.calendriers = calendriers;
    }

    public List<Notification> getNotification() {
        return notification;
    }

    public void setNotification(List<Notification> notification) {
        this.notification = notification;
    }
}
