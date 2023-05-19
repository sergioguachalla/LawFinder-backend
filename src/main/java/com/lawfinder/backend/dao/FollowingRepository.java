package com.lawfinder.backend.dao;


import com.lawfinder.backend.Entity.FollowingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowingRepository extends JpaRepository<FollowingEntity,Long> {
}
