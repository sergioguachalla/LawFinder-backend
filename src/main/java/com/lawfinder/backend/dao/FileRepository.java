package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface FileRepository extends JpaRepository<FileEntity,Long> {
    @Query("SELECT f FROM FileEntity f WHERE f.fileId = :fileId")
    FileEntity findByFileId(@Param("fileId") Long id);


}
