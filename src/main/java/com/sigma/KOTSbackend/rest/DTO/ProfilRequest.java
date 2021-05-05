package com.sigma.KOTSbackend.rest.DTO;

public class ProfilRequest {

    private String mail;
    private String description;
    private String twitch;
    private String youtube;

    public ProfilRequest(String mail, String description, String twitch, String youtube) {
        this.mail = mail;
        this.description = description;
        this.twitch = twitch;
        this.youtube = youtube;
    }

    public String getMail() {
        return mail;
    }

    public String getDescription() {
        return description;
    }

    public String getTwitch() {
        return twitch;
    }

    public String getYoutube() {
        return youtube;
    }
}
