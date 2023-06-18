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
       "FROM Audience a " +
       "WHERE a.instanceLegalCaseId IN (" +
       "    SELECT lc.legalCaseId " +
       "    FROM LegalCase lc " +
       "    WHERE lc.userId = :userId" +
       ") " +
       "OR a.instanceLegalCaseId IN (" +
       "    SELECT ac.legalCaseId " +
       "    FROM Actor ac " +
       "    WHERE ac.userId = userId" +
    ")")
    List<AudienceEntity> findaudienceByuserId(@Param ("userId") Long userId);
     
    
}