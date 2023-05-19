package com.lawfinder.backend.dao;
import com.lawfinder.backend.Entity.UserNotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserNotificationRepository extends JpaRepository<UserNotificationEntity,Long> {
}