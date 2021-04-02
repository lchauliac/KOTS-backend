package com.sigma.KOTSbackend.rest.DTO;

public class EventRequest {
    private int idEvent;
    private int idUser;

    public EventRequest(int idEvent, int idUser) {
        this.idEvent = idEvent;
        this.idUser = idUser;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
