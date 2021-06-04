package com.sigma.KOTSbackend.rest.DTO;

public class ValidateParticipationRequest {

    private int idRun;
    private int idEvent;
    private String state;

    public ValidateParticipationRequest(int idRun, int idEvent, String state) {
        this.idRun = idRun;
        this.idEvent = idEvent;
        this.state = state;
    }

    public ValidateParticipationRequest(){

    }

    public int getIdRun() {
        return idRun;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public String getState() {
        return state;
    }
}
