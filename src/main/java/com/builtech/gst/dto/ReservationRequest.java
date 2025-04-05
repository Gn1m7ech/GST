package com.builtech.gst.dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public class ReservationRequest {

    @NotNull
    private List<CalendrierRequest> calendrierRequests;

    @NotNull
    private long client;

    @NotNull
    private long stade;

    public ReservationRequest(List<CalendrierRequest> calendrierRequests, long client, long stade) {
        this.calendrierRequests = calendrierRequests;
        this.client = client;
        this.stade = stade;
    }

    public ReservationRequest() {
    }

    public List<CalendrierRequest> getCalendDtos() {
        return calendrierRequests;
    }

    public void setCalendDtos(List<CalendrierRequest> calendrierRequests) {
        this.calendrierRequests = calendrierRequests;
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
