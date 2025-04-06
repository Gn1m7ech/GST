package com.builtech.gst.dto;

import java.util.Date;

public class CalendrierDto {

    private Date debut;
    private Date fin;

    public CalendrierDto(Date debut, Date fin) {
        this.debut = debut;
        this.fin = fin;
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
