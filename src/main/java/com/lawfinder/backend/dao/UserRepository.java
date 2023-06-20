package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<UserEntity,Long> {

    @Query("SELECT u FROM UserEntity u WHERE u.username = :username")
    public UserEntity findAllByUsername(@Param("username") String username);

    @Query("SELECT u FROM UserEntity u WHERE u.personId.email = :email")
    public UserEntity findByEmail(@Param("email") String email);

    @Query("SELECT u FROM UserEntity u WHERE u.id = :userId")
    UserEntity findByUserId(@Param("userId") Long userId);






}