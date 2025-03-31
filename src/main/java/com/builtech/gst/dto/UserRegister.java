package com.builtech.gst.dto;

public class UserRegister {

    private String nom;
    private String email;
    private String password;
    private String contact;

    public UserRegister(String nom, String email, String password, String contact) {
        this.nom = nom;
        this.email = email;
        this.password = password;
        this.contact = contact;
    }

    public UserRegister(){

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}
