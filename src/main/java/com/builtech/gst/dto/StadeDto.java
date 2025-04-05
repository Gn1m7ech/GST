package com.builtech.gst.dto;

public class StadeDto {

    private String name;
    private String adresse;
    private String localisation;
    private String contact;

    public StadeDto(String name, String adresse, String localisation, String contact) {
        this.name = name;
        this.adresse = adresse;
        this.localisation = localisation;
        this.contact = contact;
    }

    public StadeDto() {
    }

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

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
