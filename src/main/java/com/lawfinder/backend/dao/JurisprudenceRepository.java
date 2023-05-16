package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.JurisprudenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JurisprudenceRepository extends JpaRepository<JurisprudenceEntity,Long> {
}
