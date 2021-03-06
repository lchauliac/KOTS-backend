package com.sigma.KOTSbackend.domain;

import com.sigma.KOTSbackend.rest.DTO.UserLightDTO;

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

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    public RunEntity(int timer, String videoid, UserEntity user) {
        this.timer = timer;
        this.videoid = videoid;
        this.user = user;
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}