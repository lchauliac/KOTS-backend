package com.sigma.KOTSbackend.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@IdClass(PlayerEntityPK.class)
@Table(name = "player")
public class PlayerEntity implements Serializable {
    @Id
    @Column(name = "iduser")
    private int iduser;

    @Id
    @Column(name = "idchallenge")
    private int idchallenge;

    @Column(name = "timer")
    private String timer;

    @Column(name = "url_youtube")
    private String urlYoutube;

    @Column(name = "ranking")
    private int ranking;

    @Column(name = "approved")
    private boolean approved;

    public PlayerEntity(int iduser, int idchallenge, String timer, String urlYoutube) {
        this.iduser = iduser;
        this.idchallenge = idchallenge;
        this.timer = timer;
        this.urlYoutube = urlYoutube;
    }

    public PlayerEntity(){}

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdchallenge() {
        return idchallenge;
    }

    public void setIdchallenge(int idchallenge) {
        this.idchallenge = idchallenge;
    }

    public String getTimer() {
        return timer;
    }

    public void setTimer(String timer) {
        this.timer = timer;
    }

    public String getUrlYoutube() {
        return urlYoutube;
    }

    public void setUrlYoutube(String urlYoutube) {
        this.urlYoutube = urlYoutube;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}


