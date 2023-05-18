package com.lawfinder.backend.dao;
import com.lawfinder.backend.Entity.HistoryFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryFileRepository extends JpaRepository<HistoryFileEntity,Long> {
    
}
