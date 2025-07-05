package com.competenceservice.Mapper;

import com.competenceservice.dto.CompetenceDTO;
import com.competenceservice.dto.SousCompetenceDTO;
import com.competenceservice.entity.Competence;
import com.competenceservice.entity.SousCompetence;

import java.util.List;
import java.util.stream.Collectors;

public class CompetenceMapper {


    public static CompetenceDTO toDTO(Competence competence) {
        if (competence == null) return null;

        List<SousCompetenceDTO> sousCompetencesDTO = (competence.getSousCompetences() != null)
                ? competence.getSousCompetences()
                .stream()
                .map(SousCompetenceMapper::toDTO)
                .collect(Collectors.toList())
                : List.of(); // أو new ArrayList<>();

        CompetenceDTO dto = new CompetenceDTO();
        dto.setId(competence.getId());
        dto.setNom(competence.getNom());
        dto.setValide(competence.isValide());
        dto.setSousCompetences(sousCompetencesDTO);

        return dto;
    }



    public static SousCompetenceDTO toDTO(SousCompetence sousCompetence) {
        if (sousCompetence == null) return null;

        SousCompetenceDTO dto = new SousCompetenceDTO();
        dto.setId(sousCompetence.getId());
        dto.setNom(sousCompetence.getNom());
        dto.setValide(sousCompetence.isValide());

        return dto;
    }


    public static Competence toEntity(CompetenceDTO dto) {
        if (dto == null) return null;

        Competence competence = new Competence();
        competence.setId(dto.getId());
        competence.setNom(dto.getNom());
        competence.setValide(dto.isValide());

        if (dto.getSousCompetences() != null) {
            List<SousCompetence> sousCompetences = dto.getSousCompetences()
                    .stream()
                    .map(CompetenceMapper::toEntity)
                    .collect(Collectors.toList());

            competence.setSousCompetences(sousCompetences);
            sousCompetences.forEach(sc -> sc.setCompetence(competence));
        } else {
            competence.setSousCompetences(null);
        }

        return competence;
    }



    public static SousCompetence toEntity(SousCompetenceDTO dto) {
        if (dto == null) return null;

        SousCompetence sousCompetence = new SousCompetence();
        sousCompetence.setId(dto.getId());
        sousCompetence.setNom(dto.getNom());
        sousCompetence.setValide(dto.isValide());

        return sousCompetence;
    }
}
