package com.competenceservice.dto;

import java.util.List;

public class CompetenceDTO {

    private Long id;
    private String nom;
    private boolean valide;
    private List<SousCompetenceDTO> sousCompetences;

    public CompetenceDTO() {
    }

    public CompetenceDTO(Long id, String nom, boolean valide, List<SousCompetenceDTO> sousCompetences) {
        this.id = id;
        this.nom = nom;
        this.valide = valide;
        this.sousCompetences = sousCompetences;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public List<SousCompetenceDTO> getSousCompetences() {
        return sousCompetences;
    }

    public void setSousCompetences(List<SousCompetenceDTO> sousCompetences) {
        this.sousCompetences = sousCompetences;
    }
}
