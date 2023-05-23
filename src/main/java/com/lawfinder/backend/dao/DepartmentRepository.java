package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
    @Query("SELECT d FROM DepartmentEntity d WHERE d.departmentId = :departmentId")
    public List<DepartmentEntity> findByDepartmentId(@Param("departmentId") Long departmentId);
}