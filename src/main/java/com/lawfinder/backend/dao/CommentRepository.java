package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.CommentEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    @Query("SELECT c FROM CommentEntity c WHERE c.legalCaseId.legalCaseId = :legalCaseId")
    Page<CommentEntity> findByLegalCaseId(@Param("legalCaseId") Long legalCaseId, Pageable pageable);

}
