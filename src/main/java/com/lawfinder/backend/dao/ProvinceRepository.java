package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinceRepository extends JpaRepository<ProvinceEntity,Long> {
}