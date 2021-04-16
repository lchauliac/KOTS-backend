package com.sigma.KOTSbackend.rest.DTO;

public class UserRequest {
    private String username;
    private String password;
    private String mail;
    private String description;
    private String twitch;
    private String youtube;

    public UserRequest(String username, String password, String mail, String description, String twitch, String youtube) {
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.description = description;
        this.twitch = twitch;
        this.youtube = youtube;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
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
