package com.builtech.gst.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
@DiscriminatorValue("CLIENT")
public class Client extends Utilisateur{

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    private List<Reservation> reservations;

}
