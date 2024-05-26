package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.LogLevelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogLevelRepository extends JpaRepository<LogLevelEntity,Long> {
}
