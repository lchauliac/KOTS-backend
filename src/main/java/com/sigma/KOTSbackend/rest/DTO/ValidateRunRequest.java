package com.sigma.KOTSbackend.rest.DTO;

public class ValidateRunRequest {

    private int idUser;
    private int idEvent;
    private boolean validation;

    public ValidateRunRequest(int idUser, int idEvent, boolean validation) {
        this.idUser = idUser;
        this.idEvent = idEvent;
        this.validation = validation;
    }

    public ValidateRunRequest(){

    }

    public int getIdUser() {
        return idUser;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public boolean isValidation() {
        return validation;
    }
}
