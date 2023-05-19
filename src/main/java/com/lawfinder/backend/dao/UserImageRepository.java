package com.lawfinder.backend.dao;
import com.lawfinder.backend.Entity.UserImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserImageRepository extends JpaRepository<UserImageEntity,Long> {
}