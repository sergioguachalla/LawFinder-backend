package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.PrivilegeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PrivilegeRepository extends JpaRepository<PrivilegeEntity,Long> {

    @Query("SELECT p FROM PrivilegeEntity p WHERE p.status = ?1")
    List<PrivilegeEntity> findAllByStatus(int status);

    PrivilegeEntity findByPriv(String priv);
    
}
