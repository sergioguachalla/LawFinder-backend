package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entitity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
}