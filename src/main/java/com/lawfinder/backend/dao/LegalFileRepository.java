package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.LegalFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LegalFileRepository extends  JpaRepository<LegalFileEntity,Long>{}