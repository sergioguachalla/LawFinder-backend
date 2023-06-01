package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.InstanceLegalCaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstanceLegalCaseRepository extends JpaRepository<InstanceLegalCaseEntity, Long> {
}