package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.LegalFileEntity;
import com.lawfinder.backend.dto.FileQueryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LegalFileRepository extends JpaRepository<LegalFileEntity, Long> {
    @Query(value = "SELECT f.url, f.tx_date, lf.summary " +
            "FROM file f " +
            "JOIN legal_file lf ON f.file_id = lf.file_id " +
            "JOIN instance_legal_case il ON lf.instance_legal_case_id = il.instance_legal_case_id " +
            "JOIN legal_case lc ON il.legal_case_id = lc.legal_case_id " +
            "WHERE lc.legal_case_id = :caseId", nativeQuery = true)
    List<String> findByCaseId(@Param("caseId") Long caseId);

    @Query(value = """
            SELECT f.url, lf.summary, i.instance_name
            FROM file AS f
            JOIN legal_file AS lf ON f.file_id = lf.file_id
            JOIN instance_legal_case AS ilc ON lf.instance_legal_case_id = ilc.instance_legal_case_id
            JOIN instance AS i ON i.instance_id = ilc.instance_id
            JOIN legal_case AS lc ON lc.legal_case_id = ilc.legal_case_id
            WHERE lc.legal_case_id = 8
            AND i.instance_name = 'Instancia Preliminar'
            """, nativeQuery = true)

    List<String[]> findByLegalCaseIdAndInstanceName(@Param("legalCaseId") Long legalCaseId, @Param("instanceName") String instanceName);

}
