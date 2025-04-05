package com.builtech.gst.dto;

import java.util.Date;

public class ReservationDto {

    private String client;
    private String stade;
    private Date bookedAt;
    private long price;
    private String status;
    //Ajouter la liste des dates reservees

    public ReservationDto(String client, String stade, Date bookedAt, long price, String status) {
        this.client = client;
        this.stade = stade;
        this.bookedAt = bookedAt;
        this.price = price;
        this.status = status;
    }

    public ReservationDto() {
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getStade() {
        return stade;
    }

    public void setStade(String stade) {
        this.stade = stade;
    }

    public Date getBookedAt() {
        return bookedAt;
    }

    public void setBookedAt(Date bookedAt) {
        this.bookedAt = bookedAt;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
