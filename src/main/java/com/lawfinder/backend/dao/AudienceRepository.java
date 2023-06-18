package com.lawfinder.backend.dao;
import com.lawfinder.backend.Entity.AudienceEntity;
import com.lawfinder.backend.Entity.LegalCaseEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AudienceRepository extends JpaRepository<AudienceEntity,Long>{


    /*SELECT *
FROM AUDIENCE 
WHERE INSTANCE_LEGAL_CASE_ID IN (
    SELECT LEGAL_CASE_ID 
    FROM LEGAL_CASE 
    WHERE USER_ID = 3
) 
OR INSTANCE_LEGAL_CASE_ID IN (
    SELECT LEGAL_CASE_ID 
    FROM ACTOR 
    WHERE USER_ID = 3
); */
    
    @Query("SELECT a " +
       "FROM AudienceEntity a " +
       "WHERE a.instanceLegalCase IN (" +
       "    SELECT lc.legalCaseId " +
       "    FROM LegalCaseEntity lc " +
       "    WHERE lc.user.id = :userId" +
       ") " +
       "OR a.instanceLegalCase IN (" +
       "    SELECT ac.legalCaseId " +
       "    FROM ActorEntity ac " +
       "    WHERE ac.userId.id = :userId" +
    ")")
    List<AudienceEntity> findaudienceByuserId(@Param ("userId") Long userId);
     
    
}