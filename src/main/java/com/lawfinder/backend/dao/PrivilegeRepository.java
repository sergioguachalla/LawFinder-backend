package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.PrivilegeEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PrivilegeRepository extends JpaRepository<PrivilegeEntity,Long> {
    
}
