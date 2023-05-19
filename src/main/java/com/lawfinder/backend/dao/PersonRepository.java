package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<PersonEntity,Long> {
    
}
