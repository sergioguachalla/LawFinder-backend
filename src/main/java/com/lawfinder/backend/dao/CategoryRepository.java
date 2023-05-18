package com.lawfinder.backend.dao;
import com.lawfinder.backend.Entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long>{}
