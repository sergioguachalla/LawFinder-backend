package com.lawfinder.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lawfinder.backend.Entity.Confidentiality;

public interface ConfidentialityRepository extends JpaRepository<Confidentiality, Long>{
   
   Confidentiality findByDescription(String description);
}
