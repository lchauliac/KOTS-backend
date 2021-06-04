package com.sigma.KOTSbackend.rest.DTO;

public class ParticipationRequest {

    private int idUser;
    private int idEvent;
    private String timer;
    private String videoid;

    public ParticipationRequest(int idUser, int idEvent, String timer, String videoid) {
        this.idUser = idUser;
        this.idEvent = idEvent;
        this.timer = timer;
        this.videoid = videoid;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public String getTimer() {
        return timer;
    }

    public String getVideoid() {
        return videoid;
    }
}
