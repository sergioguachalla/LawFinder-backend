package com.lawfinder.backend.dao;
import com.lawfinder.backend.Entity.HistoryUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HistoryUserRepository extends JpaRepository<HistoryUserEntity,Long> {}
