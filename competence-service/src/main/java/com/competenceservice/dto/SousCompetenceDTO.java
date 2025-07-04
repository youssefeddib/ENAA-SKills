package com.competenceservice.dto;

public class SousCompetenceDTO {

    private Long id;
    private String nom;
    private boolean valide;

    // معرف الـ Competence الأب (لربط الـ SousCompetence بالـ Competence)
    private Long competenceId;

    public SousCompetenceDTO() {
    }

    public SousCompetenceDTO(Long id, String nom, boolean valide, Long competenceId) {
        this.id = id;
        this.nom = nom;
        this.valide = valide;
        this.competenceId = competenceId;
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

    public Long getCompetenceId() {
        return competenceId;
    }

    public void setCompetenceId(Long competenceId) {
        this.competenceId = competenceId;
    }
}
