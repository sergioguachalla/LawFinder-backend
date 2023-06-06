package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.InstanceLegalCaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InstanceLegalCaseRepository extends JpaRepository<InstanceLegalCaseEntity, Long> {

    List<InstanceLegalCaseEntity> findAll();

    @Query("SELECT i FROM InstanceLegalCaseEntity i WHERE i.legalCase.legalCaseId = :legalCaseId")
    InstanceLegalCaseEntity findByInstanceLegalCaseId(@Param("legalCaseId") Long legalCaseId);

}