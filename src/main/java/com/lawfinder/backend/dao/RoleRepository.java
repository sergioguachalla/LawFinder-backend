package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
    
}
