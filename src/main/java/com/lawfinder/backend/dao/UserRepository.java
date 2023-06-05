package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.UserEntity;
import com.lawfinder.backend.Entity.UserRoleEntity;
import jakarta.persistence.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    @Query("SELECT u FROM UserEntity u WHERE u.username = :username")
    public UserEntity findAllByUsername(@Param("username") String username);

    @Query("SELECT u FROM UserEntity u WHERE u.personId.email = :email")
    public UserEntity findByEmail(@Param("email") String email);








}