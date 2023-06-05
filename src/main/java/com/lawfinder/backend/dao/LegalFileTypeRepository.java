package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.LegalFileTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LegalFileTypeRepository extends  JpaRepository<LegalFileTypeEntity,Long>{}