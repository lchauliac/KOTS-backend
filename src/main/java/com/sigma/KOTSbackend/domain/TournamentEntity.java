package com.sigma.KOTSbackend.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tournament")
public class TournamentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "specificity")
    private String specificity;

    @Column(name = "description")
    private String description;

    @Column(name = "conditions")
    private String conditions;

    @Column(name = "iduser")
    private int idUser;

    public TournamentEntity(String specificity, String description, String conditions, int idUser) {
        this.specificity = specificity;
        this.description = description;
        this.conditions = conditions;
        this.idUser = idUser;
    }

    public TournamentEntity(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecificity() {
        return specificity;
    }

    public void setSpecificity(String specificity) {
        this.specificity = specificity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
