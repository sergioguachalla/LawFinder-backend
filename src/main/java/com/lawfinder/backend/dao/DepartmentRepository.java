package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.DepartmentEntity;
import com.lawfinder.backend.Entity.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
    @Query("SELECT d FROM DepartmentEntity d WHERE d.departmentId = :departmentId")
    List<DepartmentEntity> findByDepartmentId(@Param("departmentId") Long departmentId);

    @Query("SELECT d FROM ProvinceEntity d WHERE d.department.departmentId = :departmentId")
    List<ProvinceEntity> findProvinceByDepartmentId(@Param("departmentId") Long departmentId);


}