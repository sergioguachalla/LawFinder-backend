package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.ApplicationLogEntity;
import com.lawfinder.backend.Entity.SecurityLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityLogsRepository extends JpaRepository<SecurityLogEntity,Long> {
}
