package com.lawfinder.backend.dao;
import com.lawfinder.backend.Entity.ActorEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ActorRepository extends JpaRepository<ActorEntity,Long>{
    
    @Query("SELECT a FROM ActorEntity a WHERE a.userId.id = :userId AND a.status = false")
    List<ActorEntity> findInvitationByUserId(@Param("userId") Long userId);

}