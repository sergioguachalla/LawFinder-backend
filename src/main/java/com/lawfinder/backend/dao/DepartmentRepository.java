package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
    public List<DepartmentEntity> findByDepartmentId(Long departmentId);
}