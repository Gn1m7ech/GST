package com.builtech.gst.dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public class ReservationDto {

    @NotNull
    private List<CalendrierDto> calendrierDtos;

    @NotNull
    private long client;

    @NotNull
    private long stade;

    public ReservationDto(List<CalendrierDto> calendrierDtos, long client, long stade) {
        this.calendrierDtos = calendrierDtos;
        this.client = client;
        this.stade = stade;
    }

    public ReservationDto() {
    }

    public List<CalendrierDto> getCalendDtos() {
        return calendrierDtos;
    }

    public void setCalendDtos(List<CalendrierDto> calendrierDtos) {
        this.calendrierDtos = calendrierDtos;
    }

    public long getClient() {
        return client;
    }

    public void setClient(long client) {
        this.client = client;
    }

    public long getStade() {
        return stade;
    }

    public void setStade(long stade) {
        this.stade = stade;
    }
}
