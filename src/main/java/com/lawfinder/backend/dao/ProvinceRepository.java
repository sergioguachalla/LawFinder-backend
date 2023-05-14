package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entitity.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinceRepository extends JpaRepository<ProvinceEntity,Long> {
}