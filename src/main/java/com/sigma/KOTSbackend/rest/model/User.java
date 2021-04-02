package com.sigma.KOTSbackend.rest.model;

public class User {
    private int id;

    private String username;
    private String mail;
    private String twitchLink;
    private String firstName;
    private String lastname;

    public User(int id, String username, String mail, String twitchLink ,String firstName, String lastname){
        this.id=id;
        this.username=username;
        this.mail=mail;
        this.twitchLink=twitchLink;
        this.firstName=firstName;
        this.lastname=lastname;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTwitchLink() {
        return twitchLink;
    }

    public void setTwitchLink(String twitchLink) {
        this.twitchLink = twitchLink;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
