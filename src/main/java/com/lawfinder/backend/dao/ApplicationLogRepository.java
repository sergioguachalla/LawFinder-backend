package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.ApplicationLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationLogRepository extends JpaRepository<ApplicationLogEntity,Long> {
}
