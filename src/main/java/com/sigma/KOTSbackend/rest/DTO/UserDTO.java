package com.sigma.KOTSbackend.rest.DTO;

import javax.persistence.Column;

public class UserDTO {

    private int id;

    private String username;

    private String description;

    private String mail;

    private String twitch;

    private String youtube;

    public UserDTO(int id, String username, String description, String mail, String twitch, String youtube) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.mail = mail;
        this.twitch = twitch;
        this.youtube = youtube;
    }

    public UserDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTwitch() {
        return twitch;
    }

    public void setTwitch(String twitch) {
        this.twitch = twitch;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }
}
