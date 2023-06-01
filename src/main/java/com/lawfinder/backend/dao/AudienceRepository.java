package com.lawfinder.backend.dao;
import com.lawfinder.backend.Entity.AudienceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudienceRepository extends JpaRepository<AudienceEntity,Long>{
}