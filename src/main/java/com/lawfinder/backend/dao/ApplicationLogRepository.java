package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.ApplicationLogEntity;
import com.lawfinder.backend.Entity.LegalCaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ApplicationLogRepository extends JpaRepository<ApplicationLogEntity,Long>, JpaSpecificationExecutor<ApplicationLogEntity> {
}
