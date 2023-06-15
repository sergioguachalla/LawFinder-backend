package com.lawfinder.backend.dao;
import com.lawfinder.backend.Entity.LegalCaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/*

public interface LegalCaseRepository extends  JpaRepository<LegalCaseEntity,Long>{
   @Query(value = """
           SELECT lc.*
           FROM legal_case lc
           WHERE lc.user_id = :userId
              OR lc.legal_case_id IN (SELECT a.legal_case_id FROM actor a WHERE a.user_id = :userId and a.status = true)
""",
           countQuery = "SELECT COUNT(*) FROM legal_case lc, actor a WHERE lc.user_id = :userId or a.user_id = :userId and a.status = true",
           nativeQuery = true)
   Page<LegalCaseEntity> findAllByUserId(@Param("userId") Long userId, Pageable pageable);

    @Query(value = """
       SELECT lc.*
       FROM legal_case lc
       WHERE (lc.user_id = :userId
          OR lc.legal_case_id IN (SELECT a.legal_case_id FROM actor a WHERE a.user_id = :userId and a.status = true))
          AND (CAST(lc.start_date AS DATE) BETWEEN :from AND :to)
""",
       countQuery = "SELECT COUNT(*) FROM legal_case lc, actor a WHERE (lc.user_id = :userId or a.user_id = :userId and a.status = true) and (CAST(lc.start_date AS DATE) BETWEEN :from AND :to)",
       nativeQuery = true)
Page<LegalCaseEntity> findAllByUserIdAndStartDateBetween(@Param("userId") Long userId, @Param("from") Date from, @Param("to") Date to, Pageable pageable);



}
*/
public interface LegalCaseRepository extends JpaRepository<LegalCaseEntity, Long>, JpaSpecificationExecutor<LegalCaseEntity> {
}

