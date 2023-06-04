package com.lawfinder.backend.dao;
import com.lawfinder.backend.Entity.LegalCaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LegalCaseRepository extends  JpaRepository<LegalCaseEntity,Long>{
    @Query(value = "select * from legal_case where user_id = :userId",nativeQuery = true)
    List<LegalCaseEntity> findAllByUserId(@Param("userId") Long userId);
}
