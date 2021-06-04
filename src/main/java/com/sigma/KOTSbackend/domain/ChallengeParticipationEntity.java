
package com.sigma.KOTSbackend.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(ChallengeParticipationEntityPK.class)
@Table(name = "challenge_participation")
public class ChallengeParticipationEntity implements Serializable {
    @Id
    @Column(name = "idrun")
    private int idrun;

    @Id
    @Column(name = "idchallenge")
    private int idchallenge;

    @Column(name = "state")
    private String state;

    @Column(name = "msgadmin")
    private String msgadmin;

    public ChallengeParticipationEntity(int idrun, int idchallenge, String state, String msgadmin) {
        this.idrun = idrun;
        this.idchallenge = idchallenge;
        this.state = state;
        this.msgadmin = msgadmin;
    }

    public ChallengeParticipationEntity() {
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMsgadmin() {
        return msgadmin;
    }

    public void setMsgadmin(String msgadmin) {
        this.msgadmin = msgadmin;
    }
}