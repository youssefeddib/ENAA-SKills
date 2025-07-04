package com.competenceservice.controller;

import com.competenceservice.Mapper.SousCompetenceMapper;
import com.competenceservice.dto.SousCompetenceDTO;
import com.competenceservice.entity.SousCompetence;
import com.competenceservice.service.SousCompetenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/sous-competences")
@CrossOrigin(origins = "*")
public class SousCompetenceController {

    private final SousCompetenceService sousCompetenceService;

    public SousCompetenceController(SousCompetenceService sousCompetenceService) {
        this.sousCompetenceService = sousCompetenceService;
    }


    @GetMapping
    public ResponseEntity<List<SousCompetenceDTO>> getAllSousCompetences() {
        List<SousCompetence> entities = sousCompetenceService.getAllSousCompetences();
        List<SousCompetenceDTO> dtos = entities.stream()
                .map(SousCompetenceMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }


    @GetMapping("/competence/{competenceId}")
    public ResponseEntity<List<SousCompetenceDTO>> getSousCompetencesByCompetenceId(@PathVariable Long competenceId) {
        List<SousCompetence> entities = sousCompetenceService.getSousCompetencesByCompetenceId(competenceId);
        List<SousCompetenceDTO> dtos = entities.stream()
                .map(SousCompetenceMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<SousCompetenceDTO> getSousCompetenceById(@PathVariable Long id) {
        Optional<SousCompetence> entityOpt = sousCompetenceService.getSousCompetenceById(id);
        return entityOpt
                .map(entity -> ResponseEntity.ok(SousCompetenceMapper.toDTO(entity)))
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<SousCompetenceDTO> createSousCompetence(@RequestBody SousCompetenceDTO dto) {
        SousCompetence entity = SousCompetenceMapper.toEntity(dto);
        SousCompetence created = sousCompetenceService.createSousCompetence(entity);
        return ResponseEntity.ok(SousCompetenceMapper.toDTO(created));
    }


    @PutMapping("/{id}/validation")
    public ResponseEntity<SousCompetenceDTO> updateValidationStatus(
            @PathVariable Long id,
            @RequestParam boolean isValid) {

        SousCompetence updated = sousCompetenceService.updateValidationStatus(id, isValid);
        return ResponseEntity.ok(SousCompetenceMapper.toDTO(updated));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSousCompetence(@PathVariable Long id) {
        sousCompetenceService.deleteSousCompetence(id);
        return ResponseEntity.noContent().build();
    }
}
