package com.sigma.KOTSbackend.rest.DTO;

public class PlayerRequest {

    private int idUser;
    private int idEvent;
    private String timer;
    private String url_youtube;

    public PlayerRequest(int idUser, int idEvent, String timer, String url_youtube) {
        this.idUser = idUser;
        this.idEvent = idEvent;
        this.timer = timer;
        this.url_youtube = url_youtube;
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

    public String getUrl_youtube() {
        return url_youtube;
    }
}
