package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.LogCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogCategoryRepository extends JpaRepository<LogCategoryEntity,Long> { }
