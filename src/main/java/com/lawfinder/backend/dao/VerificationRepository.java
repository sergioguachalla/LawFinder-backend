package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.VerificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationRepository extends JpaRepository<VerificationEntity, Long> {

}
