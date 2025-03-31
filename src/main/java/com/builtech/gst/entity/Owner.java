package com.builtech.gst.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;

@Entity
@DiscriminatorValue("OWNER")
public class Owner extends Utilisateur{

    @OneToOne(fetch = FetchType.EAGER)
    private Stade stade;

}
