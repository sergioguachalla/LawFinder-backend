package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entitity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileEntity,Long> {
}
