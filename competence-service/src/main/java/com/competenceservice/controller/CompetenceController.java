package com.competenceservice.controller;

import com.competenceservice.dto.CompetenceDTO;
import com.competenceservice.service.CompetenceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Competences", description = "Endpoints gestion des compétences")
@RestController
@RequestMapping("/api/competences")
@CrossOrigin(origins = "*")
public class CompetenceController {

    private final CompetenceService competenceService;

    public CompetenceController(CompetenceService competenceService) {
        this.competenceService = competenceService;
    }

    @Operation(summary = "Create a competence")
    @PostMapping
    public ResponseEntity<CompetenceDTO> createCompetence(@RequestBody CompetenceDTO competenceDTO) {
        CompetenceDTO created = competenceService.createCompetence(competenceDTO);
        return ResponseEntity.ok(created);
    }


    @GetMapping
    public ResponseEntity<List<CompetenceDTO>> getAllCompetences() {
        List<CompetenceDTO> list = competenceService.getAllCompetences();
        return ResponseEntity.ok(list);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CompetenceDTO> getCompetenceById(@PathVariable Long id) {
        Optional<CompetenceDTO> competenceOpt = competenceService.getCompetenceById(id);
        return competenceOpt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<CompetenceDTO> updateCompetence(@PathVariable Long id, @RequestBody CompetenceDTO competenceDTO) {
        CompetenceDTO updated = competenceService.updateCompetence(id, competenceDTO);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompetence(@PathVariable Long id) {
        competenceService.deleteCompetence(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}/validation")
    public ResponseEntity<CompetenceDTO> updateCompetenceValidation(@PathVariable Long id) {
        CompetenceDTO updated = competenceService.updateCompetenceValidation(id);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
