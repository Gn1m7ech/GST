package com.builtech.gst.dto;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class CalendrierDto {

    @NotNull
    private Date debut;

    @NotNull
    private Date fin;

    public CalendrierDto(Date debut, Date fin) {
        this.debut = debut;
        this.fin = fin;
    }

    public CalendrierDto() {
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
}
