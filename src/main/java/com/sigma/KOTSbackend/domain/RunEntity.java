package com.sigma.KOTSbackend.domain;

import javax.persistence.*;

@Entity
@Table(name = "run")
public class RunEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "timer")
    private int timer;

    @Column(name = "videoid")
    private String videoid;

    @Column(name = "iduser")
    private int idUser;

    public RunEntity(int timer, String videoid, int idUser) {
        this.timer = timer;
        this.videoid = videoid;
        this.idUser = idUser;
    }

    public RunEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public String getVideoid() {
        return videoid;
    }

    public void setVideoid(String videoid) {
        this.videoid = videoid;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}