package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.InstanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstanceRepository extends JpaRepository<InstanceEntity, Long> {
}
