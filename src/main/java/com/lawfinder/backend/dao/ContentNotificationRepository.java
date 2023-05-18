package com.lawfinder.backend.dao;
import com.lawfinder.backend.Entity.ContentNotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentNotificationRepository extends JpaRepository<ContentNotificationEntity,Long> {
    
}
