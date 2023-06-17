package com.lawfinder.backend.dao;
import com.lawfinder.backend.Entity.LegalCaseEntity;
import com.lawfinder.backend.dto.CaseInformationDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;



public interface LegalCaseRepository extends  JpaRepository<LegalCaseEntity,Long>{
   /*@Query(value = """
           SELECT *
           FROM LEGAL_CASE
           WHERE USER_ID = :userId
              OR LEGAL_CASE_ID IN (SELECT LEGAL_CASE_ID FROM ACTOR WHERE USER_ID = :userId)""",

           countQuery = "SELECT COUNT(*) FROM legal_case lc, actor a WHERE lc.user_id = :userId or a.user_id = :userId and status = true",
           nativeQuery = true)
   Page<LegalCaseEntity> findAllByUserId(@Param("userId") Long userId, Pageable pageable);*/
   @Query(value = """
           SELECT lc.*
           FROM legal_case lc
           WHERE lc.user_id = :userId
              OR lc.legal_case_id IN (SELECT a.legal_case_id FROM actor a WHERE a.user_id = :userId and a.status = true)
""",
           countQuery = "SELECT COUNT(*) FROM legal_case lc, actor a WHERE lc.user_id = :userId or a.user_id = :userId and a.status = true",
           nativeQuery = true)
   Page<LegalCaseEntity> findAllByUserId(@Param("userId") Long userId, Pageable pageable);



   @Query(
           value = """
        SELECT pr.province_name, lc.title, usr.username, i.instance_name, lc.tx_date, sc.sub_category_name, cri.name, lc.summary
        FROM province pr
        JOIN legal_case lc ON pr.province_id = lc.province_id
        JOIN se_user usr ON lc.user_id = usr.user_id
        JOIN instance_legal_case ilc ON ilc.legal_case_id = lc.legal_case_id
        JOIN instance i ON i.instance_id = ilc.instance_id
        JOIN crime cri ON cri.crime_id = lc.crime_id
        JOIN sub_category sc ON sc.subcategory_id = cri.subcategory_id
        WHERE lc.legal_case_id = :caseId
     """,
           nativeQuery = true
   )



   List<String> caseInformationByCaseId(@Param("caseId") Long caseId);


   /*@Query(value = "SELECT lc.* FROM legal_case lc LEFT JOIN actor a ON lc.user_id = a.user_id WHERE lc.user_id = :userId OR a.user_id = :userId AND lc.status = true",
           countQuery = "SELECT COUNT(*) FROM legal_case lc LEFT JOIN actor a ON lc.user_id = a.user_id WHERE lc.user_id = :userId OR a.user_id = :userId AND lc.status = true",
           nativeQuery = true)
   Page<LegalCaseEntity> findAllByUserId(@Param("userId") Long userId, Pageable pageable);
*/

}
