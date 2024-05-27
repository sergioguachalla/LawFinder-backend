package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.ApplicationLogEntity;
import com.lawfinder.backend.Entity.SecurityLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SecurityLogsRepository extends JpaRepository<SecurityLogEntity,Long>, JpaSpecificationExecutor<SecurityLogEntity> {
}
