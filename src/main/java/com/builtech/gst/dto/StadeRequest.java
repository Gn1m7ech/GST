package com.builtech.gst.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class StadeRequest {

    @NotNull
    private String name;
    @NotNull
    private String adresse;
    @NotNull
    private String location;
    @NotNull @Size(min = 8, max = 8, message = "only the 8 numbers without the country code")
    private String contact;
    @NotNull
    private List<String> images = new ArrayList<>();
    @NotNull
    private long owner;

    public StadeRequest(String name, String adresse, String location, String contact, List<String> images, long owner) {
        this.name = name;
        this.adresse = adresse;
        this.location = location;
        this.contact = contact;
        this.images = images;
        this.owner = owner;
    }

    public StadeRequest(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public long getOwner() {
        return owner;
    }

    public void setOwner(long owner) {
        this.owner = owner;
    }
}
