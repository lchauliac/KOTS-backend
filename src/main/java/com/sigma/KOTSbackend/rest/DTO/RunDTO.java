package com.sigma.KOTSbackend.rest.DTO;

public class RunDTO {

    private int id;
    private int timer;
    private String videoid;
    private UserLightDTO user;

    public RunDTO(int id, int timer, String videoid, UserLightDTO user) {
        this.id = id;
        this.timer = timer;
        this.videoid = videoid;
        this.user = user;
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

    public UserLightDTO getUser() {
        return user;
    }

    public void setUser(UserLightDTO user) {
        this.user = user;
    }
}
