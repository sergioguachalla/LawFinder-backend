package com.lawfinder.backend.dao;
import com.lawfinder.backend.Entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends  JpaRepository<NotificationEntity,Long>{}
