package com.sigma.KOTSbackend.rest.model;

public class Tournament {

    private int id;
    private String specificity;
    private String description;
    private String conditions;
    private int idUser;

    public Tournament(int id, String specificity, String description, String conditions, int idUser) {
        this.id=id;
        this.specificity = specificity;
        this.description = description;
        this.conditions = conditions;
        this.idUser = idUser;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id=id;
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
