package com.builtech.gst.dto;


import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public class StadeRegister {

    private String name;
    private String adresse;
    private String location;
    private String contact;
    private List<String> images = new ArrayList<>();

    public StadeRegister(String name, String adresse, String location, String contact, List<String> images) {
        this.name = name;
        this.adresse = adresse;
        this.location = location;
        this.contact = contact;
        this.images = images;
    }

    public StadeRegister(){}

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

}
