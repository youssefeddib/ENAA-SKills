package com.competenceservice.service;

import com.competenceservice.dto.CompetenceDTO;
import com.competenceservice.entity.Competence;
import com.competenceservice.entity.SousCompetence;
import com.competenceservice.Mapper.CompetenceMapper;
import com.competenceservice.repository.CompetenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompetenceService {

    private final CompetenceRepository competenceRepository;

    public CompetenceService(CompetenceRepository competenceRepository) {
        this.competenceRepository = competenceRepository;
    }


    public CompetenceDTO createCompetence(CompetenceDTO competenceDTO) {
        Competence competence = CompetenceMapper.toEntity(competenceDTO);
        competence.getSousCompetences().forEach(sc -> sc.setCompetence(competence));
        Competence saved = competenceRepository.save(competence);
        return CompetenceMapper.toDTO(saved);
    }


}
