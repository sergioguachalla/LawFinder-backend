package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    @Query("SELECT c FROM CommentEntity c WHERE c.legalCaseId.legalCaseId = :legalCaseId")
    List<CommentEntity> findByLegalCaseId(@Param("legalCaseId") Long legalCaseId);

}
