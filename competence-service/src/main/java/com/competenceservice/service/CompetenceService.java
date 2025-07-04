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


    public void deleteCompetence(Long id) {
        competenceRepository.deleteById(id);
    }


    public CompetenceDTO updateCompetence(Long id, CompetenceDTO competenceDTO) {
        Competence competence = CompetenceMapper.toEntity(competenceDTO);
        competence.setId(id);
        competence.getSousCompetences().forEach(sc -> sc.setCompetence(competence));
        Competence updated = competenceRepository.save(competence);
        return CompetenceMapper.toDTO(updated);
    }


    public Optional<CompetenceDTO> getCompetenceById(Long id) {
        Optional<Competence> competenceOpt = competenceRepository.findById(id);
        return competenceOpt.map(CompetenceMapper::toDTO);
    }


    public List<CompetenceDTO> getAllCompetences() {
        return competenceRepository.findAll()
                .stream()
                .map(CompetenceMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<Competence> getCompetenceEntityById(Long id) {
        return competenceRepository.findById(id);
    }



    public CompetenceDTO updateCompetenceValidation(Long id) {
        Optional<Competence> competenceOpt = competenceRepository.findById(id);
        if (competenceOpt.isPresent()) {
            Competence competence = competenceOpt.get();
            boolean allValid = competence.getSousCompetences().stream()
                    .allMatch(SousCompetence::isValide);
            competence.setValide(allValid);
            Competence saved = competenceRepository.save(competence);
            return CompetenceMapper.toDTO(saved);
        }
        return null;
    }
}
