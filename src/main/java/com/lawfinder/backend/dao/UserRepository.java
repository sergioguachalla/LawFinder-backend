package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends JpaRepository<UserEntity,Long> {

    @Query("SELECT u FROM UserEntity u WHERE u.personId.personId = :personId")
    public UserEntity findByPersonId(Long personId);

    @Query("SELECT u FROM UserEntity u WHERE u.username = :username and u.status = true")
    public UserEntity findAllByUsername(@Param("username") String username);

    @Query("SELECT u FROM UserEntity u WHERE u.personId.email = :email and u.status = true")
    public UserEntity findByEmail(@Param("email") String email);

    @Query("SELECT u FROM UserEntity u WHERE u.id = :userId")
    UserEntity findByUserId(@Param("userId") Long userId);

    //obtener todos los usuarios con status true
    @Query("SELECT u FROM UserEntity u WHERE u.status = true")
    List<UserEntity> findAllByStatus();






}