package com.lawfinder.backend.dao;
import com.lawfinder.backend.Entity.LegalCaseEntity;
import com.lawfinder.backend.dto.CaseInformationDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


public interface LegalCaseRepository extends JpaRepository<LegalCaseEntity, Long>, JpaSpecificationExecutor<LegalCaseEntity> {

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



  @Query(
           value = """
        SELECT pr.province_name, lc.title, usr.username, i.instance_name, lc.tx_date, sc.sub_category_name, cri.name
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


  @Query(
           value = """
        SELECT lc.summary
        FROM legal_case lc
        WHERE lc.legal_case_id = :caseId
     """,
          nativeQuery = true
  )
  String caseSummaryByCaseId(@Param("caseId") Long caseId);

  @Query(value = "Select lc from LegalCaseEntity lc where lc.legalCaseId = :legalCaseId")
  LegalCaseEntity findByLegalCaseId(@Param("legalCaseId") Long legalCaseId);



}

