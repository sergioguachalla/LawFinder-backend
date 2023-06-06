package com.lawfinder.backend.dao;
import com.lawfinder.backend.Entity.LegalCaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LegalCaseRepository extends  JpaRepository<LegalCaseEntity,Long>{
    /*@Query(value = "select * from legal_case where user_id = :userId",nativeQuery = true)
    List<LegalCaseEntity> findAllByUserId(@Param("userId") Long userId);*/

   @Query(value = """
           SELECT *
           FROM LEGAL_CASE
           WHERE USER_ID = :userId
              OR LEGAL_CASE_ID IN (SELECT LEGAL_CASE_ID FROM ACTOR WHERE USER_ID = :userId)""",

            countQuery = "SELECT COUNT(*) FROM legal_case lc, actor a WHERE lc.user_id = :userId or a.user_id = :user_id and status = true",
            nativeQuery = true)
   Page<LegalCaseEntity> findAllByUserId(@Param("userId") Long userId, Pageable pageable);

   /*@Query(value = "SELECT lc.* FROM legal_case lc LEFT JOIN actor a ON lc.user_id = a.user_id WHERE lc.user_id = :userId OR a.user_id = :userId AND lc.status = true",
           countQuery = "SELECT COUNT(*) FROM legal_case lc LEFT JOIN actor a ON lc.user_id = a.user_id WHERE lc.user_id = :userId OR a.user_id = :userId AND lc.status = true",
           nativeQuery = true)
   Page<LegalCaseEntity> findAllByUserId(@Param("userId") Long userId, Pageable pageable);
*/

}


