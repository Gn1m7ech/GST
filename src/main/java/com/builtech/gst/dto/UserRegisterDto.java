package com.builtech.gst.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.jmx.export.annotation.ManagedAttribute;

public class UserRegisterDto {

    @NotNull @Min(value = 10, message = "Entrez au minimum votre nom et le prenom")
    private String nom;

    @NotNull @Email(message = "Votre information est incorrect")
    private String email;

    @NotNull
    private String password;

    @NotNull @Size(min = 8, max = 8, message = "only the 8 numbers without the country code")
    private String contact;

    public UserRegisterDto(String nom, String email, String password, String contact) {
        this.nom = nom;
        this.email = email;
        this.password = password;
        this.contact = contact;
    }

    public UserRegisterDto() {
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
