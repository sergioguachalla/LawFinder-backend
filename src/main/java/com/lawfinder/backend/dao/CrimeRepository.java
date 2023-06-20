package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.CrimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CrimeRepository extends JpaRepository<CrimeEntity,Long> {

    @Query("SELECT c FROM CrimeEntity c WHERE c.subcategoryId.subCategoryId = :subcategoryId")
    List<CrimeEntity> findAllBySubcategoryId(Long subcategoryId);

    //encontrar un crimen por id
    @Query("SELECT c FROM CrimeEntity c WHERE c.crimeId = :crimeId")
    CrimeEntity findByCrimeId(Long crimeId);
}
