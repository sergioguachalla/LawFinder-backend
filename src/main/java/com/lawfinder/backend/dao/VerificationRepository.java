package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.VerificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VerificationRepository extends JpaRepository<VerificationEntity, Long> {

    @Query("SELECT v FROM VerificationEntity v WHERE v.personId.personId = :personId ")
    VerificationEntity findByPersonId(@Param("personId") Long personId);


}
