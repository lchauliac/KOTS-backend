package com.sigma.KOTSbackend.domain;

import java.io.Serializable;
import java.util.Objects;

public class PlayerEntityPK implements Serializable {
    private int iduser;
    private int idchallenge;

    public PlayerEntityPK(int iduser, int idchallenge) {
        this.iduser = iduser;
        this.idchallenge = idchallenge;
    }

    public PlayerEntityPK(){

    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerEntityPK that = (PlayerEntityPK) o;
        return iduser == that.iduser && idchallenge == that.idchallenge;
    }

    @Override
    public int hashCode() {
        return Objects.hash(iduser, idchallenge);
    }
}
