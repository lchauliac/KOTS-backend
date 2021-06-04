package com.sigma.KOTSbackend.domain;

import java.io.Serializable;
import java.util.Objects;

public class TournamentParticipationEntityPK implements Serializable {
    private int idrun;
    private int idtournament;

    public TournamentParticipationEntityPK(int idrun, int idtournament) {
        this.idrun = idrun;
        this.idtournament = idtournament;
    }

    public TournamentParticipationEntityPK() {

    }

    public int getIdrun() {
        return idrun;
    }

    public void setIdrun(int idrun) {
        this.idrun = idrun;
    }

    public int getIdtournament() {
        return idtournament;
    }

    public void setIdtournament(int idtournament) {
        this.idtournament = idtournament;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TournamentParticipationEntityPK that = (TournamentParticipationEntityPK) o;
        return idrun == that.idrun && idtournament == that.idtournament;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idrun, idtournament);
    }
}