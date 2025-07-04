package com.competenceservice.service;

import com.competenceservice.entity.Competence;
import com.competenceservice.entity.SousCompetence;
import com.competenceservice.repository.SousCompetenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SousCompetenceService {

    private final SousCompetenceRepository sousCompetenceRepository;
    private final CompetenceService competenceService;

    public SousCompetenceService(SousCompetenceRepository sousCompetenceRepository,
                                 CompetenceService competenceService) {
        this.sousCompetenceRepository = sousCompetenceRepository;
        this.competenceService = competenceService;
    }


    public List<SousCompetence> getAllSousCompetences() {
        return sousCompetenceRepository.findAll();
    }


    public List<SousCompetence> getSousCompetencesByCompetenceId(Long competenceId) {
        return sousCompetenceRepository.findByCompetenceId(competenceId);
    }


    public Optional<SousCompetence> getSousCompetenceById(Long id) {
        return sousCompetenceRepository.findById(id);
    }





    public SousCompetence createSousCompetence(SousCompetence sc) {
        if (sc.getCompetence() == null || sc.getCompetence().getId() == null) {
            throw new IllegalArgumentException("Competence ID must be provided");
        }

        Long competenceId = sc.getCompetence().getId();
        Competence competence = competenceService.getCompetenceEntityById(competenceId)
                .orElseThrow(() -> new RuntimeException("Competence not found with id: " + competenceId));


        sc.setCompetence(competence);

        SousCompetence saved = sousCompetenceRepository.save(sc);

        competenceService.updateCompetenceValidation(competence.getId());

        return saved;
    }



}
