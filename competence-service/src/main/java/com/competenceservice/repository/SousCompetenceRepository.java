package com.competenceservice.repository;


import com.competenceservice.entity.SousCompetence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SousCompetenceRepository extends JpaRepository<SousCompetence, Long> {

    List<SousCompetence> findByCompetenceId(Long competenceId);

}
