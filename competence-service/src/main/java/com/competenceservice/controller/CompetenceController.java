package com.competenceservice.controller;

import com.competenceservice.dto.CompetenceDTO;
import com.competenceservice.service.CompetenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/competences")
@CrossOrigin(origins = "*")
public class CompetenceController {

    private final CompetenceService competenceService;

    public CompetenceController(CompetenceService competenceService) {
        this.competenceService = competenceService;
    }


    @PostMapping
    public ResponseEntity<CompetenceDTO> createCompetence(@RequestBody CompetenceDTO competenceDTO) {
        CompetenceDTO created = competenceService.createCompetence(competenceDTO);
        return ResponseEntity.ok(created);
    }


}
