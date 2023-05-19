package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.SubCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryRepository extends JpaRepository<SubCategoryEntity,Long> {
}