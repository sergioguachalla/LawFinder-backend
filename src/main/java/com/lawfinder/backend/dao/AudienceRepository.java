package com.lawfinder.backend.dao;
import com.lawfinder.backend.Entity.AudienceEntity;
import com.lawfinder.backend.Entity.LegalCaseEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AudienceRepository extends JpaRepository<AudienceEntity,Long>{
    /* 
    @Query("select * from AudienceEntity")//SELECT a FROM AudienceEntity a WHERE a.instanceLegalCaseId IN (SELECT l.legalCaseId FROM LegalCaseEntity l WHERE l.userId = :userId) OR a.instanceLegalCaseId IN (SELECT ac.legalCaseId FROM ActorEntity ac WHERE ac.userId = :userId)")
    List <AudienceEntity> findaudienceByuserId(@Param("userId") Long userId);
    */
}