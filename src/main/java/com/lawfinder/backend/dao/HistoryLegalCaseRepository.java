package com.lawfinder.backend.dao;
import com.lawfinder.backend.Entity.HistoryLegalCaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HistoryLegalCaseRepository extends JpaRepository<HistoryLegalCaseEntity,Long> {
    
}
