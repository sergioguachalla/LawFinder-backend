package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.VerificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VerificationRepository extends JpaRepository<VerificationEntity, Long> {



    @Query(value = "SELECT * FROM se_verification WHERE device_id = :uuid", nativeQuery = true)
    VerificationEntity findByDeviceId(@Param("uuid") String uuid );


}
