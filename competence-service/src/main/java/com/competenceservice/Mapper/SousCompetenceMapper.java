package com.competenceservice.Mapper;

import com.competenceservice.dto.SousCompetenceDTO;
import com.competenceservice.entity.SousCompetence;

public class SousCompetenceMapper {


    public static SousCompetenceDTO toDTO(SousCompetence sousCompetence) {
        if (sousCompetence == null) return null;

        SousCompetenceDTO dto = new SousCompetenceDTO();
        dto.setId(sousCompetence.getId());
        dto.setNom(sousCompetence.getNom());
        dto.setValide(sousCompetence.isValide());

        if (sousCompetence.getCompetence() != null) {
            dto.setCompetenceId(sousCompetence.getCompetence().getId());
        }

        return dto;
    }


    public static SousCompetence toEntity(SousCompetenceDTO dto) {
        if (dto == null) return null;

        SousCompetence entity = new SousCompetence();
        entity.setId(dto.getId());
        entity.setNom(dto.getNom());
        entity.setValide(dto.isValide());


        if (dto.getCompetenceId() != null) {
            entity.setCompetence(new com.competenceservice.entity.Competence());
            entity.getCompetence().setId(dto.getCompetenceId());
        }

        return entity;
    }
}
