package com.sigma.KOTSbackend.domain;

import javax.persistence.*;
import java.io.Serializable;

    @Entity
    @IdClass(TournamentParticipationEntityPK.class)
    @Table(name = "tournament_participation")
    public class TournamentParticipationEntity implements Serializable {
        @Id
        @Column(name = "idrun")
        private int idrun;

        @Id
        @Column(name = "idtournament")
        private int idtournament;

        @Column(name = "state")
        private String state;

        @Column(name = "msgadmin")
        private String msgadmin;

        public TournamentParticipationEntity(int idrun, int idtournament, String state, String msgadmin) {
            this.idrun = idrun;
            this.idtournament = idtournament;
            this.state = state;
            this.msgadmin = msgadmin;
        }

        public TournamentParticipationEntity() {
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
