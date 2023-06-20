package com.lawfinder.backend.dao;
import com.lawfinder.backend.Entity.AudienceEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AudienceRepository extends JpaRepository<AudienceEntity,Long>{
    @Query("SELECT a " +
            "FROM AudienceEntity a " +
            "JOIN a.legalCaseId lc " +
            "WHERE lc.user.id = :userId " +
            "OR a.legalCaseId IN (SELECT ac.legalCaseId FROM ActorEntity ac WHERE ac.userId.id = :userId)")
    List<AudienceEntity> findAudienceByUserId(@Param("userId") Long userId);
}