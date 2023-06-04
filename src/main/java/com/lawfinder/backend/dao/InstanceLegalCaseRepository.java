package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.InstanceLegalCaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstanceLegalCaseRepository extends JpaRepository<InstanceLegalCaseEntity, Long> {

    List<InstanceLegalCaseEntity> findAll();
}