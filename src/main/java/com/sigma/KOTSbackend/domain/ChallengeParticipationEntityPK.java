package com.sigma.KOTSbackend.domain;

import java.io.Serializable;
import java.util.Objects;

public class ChallengeParticipationEntityPK implements Serializable {
    private int idrun;
    private int idchallenge;

    public ChallengeParticipationEntityPK(int idrun, int idchallenge) {
        this.idrun = idrun;
        this.idchallenge = idchallenge;
    }

    public ChallengeParticipationEntityPK() {

    }

    public int getIdrun() {
        return idrun;
    }

    public void setIdrun(int idrun) {
        this.idrun = idrun;
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
        ChallengeParticipationEntityPK that = (ChallengeParticipationEntityPK) o;
        return idrun == that.idrun && idchallenge == that.idchallenge;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idrun, idchallenge);
    }
}