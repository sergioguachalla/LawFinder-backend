package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entitity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
}