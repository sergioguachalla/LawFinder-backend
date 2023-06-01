package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.CourtEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourtRepository extends JpaRepository<CourtEntity, Long> {
}
