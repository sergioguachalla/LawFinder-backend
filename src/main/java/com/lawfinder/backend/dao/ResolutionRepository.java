package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.ResolutionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResolutionRepository extends JpaRepository<ResolutionEntity, Long> {
}