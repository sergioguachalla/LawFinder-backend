package com.lawfinder.backend.dao;
import com.lawfinder.backend.Entity.LegalCaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LegalCaseRepository extends  JpaRepository<LegalCaseEntity,Long>{}
