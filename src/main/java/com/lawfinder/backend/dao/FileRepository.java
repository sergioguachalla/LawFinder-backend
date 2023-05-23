package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FileRepository extends JpaRepository<FileEntity,Long> {
    /*@Query("SELECT f FROM FileEntity f WHERE f.fileId = :fileId")
     List<FileEntity> findById(@Param("fileId") Long id);*/
    FileEntity findByFileId(Long id);
}
