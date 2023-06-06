package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.LegalFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface LegalFileRepository extends JpaRepository<LegalFileEntity, Long> {
    @Query(value = "SELECT f.url " +
            "FROM file f " +
            "JOIN legal_file lf ON f.file_id = lf.file_id " +
            "JOIN instance_legal_case il ON lf.instance_legal_case_id = il.instance_legal_case_id " +
            "JOIN legal_case lc ON il.legal_case_id = lc.legal_case_id " +
            "WHERE lc.legal_case_id = :caseId", nativeQuery = true)
    List<String> findByCaseId(@Param("caseId") Long caseId);
}
