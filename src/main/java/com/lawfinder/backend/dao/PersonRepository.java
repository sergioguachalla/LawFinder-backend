package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PersonRepository extends JpaRepository<PersonEntity,Long> {

    @Query("SELECT p FROM PersonEntity p WHERE p.email = :email ")
    PersonEntity findByEmail(@Param("email") String email);

    @Query("SELECT p FROM PersonEntity p WHERE p.name = :name AND p.lastname = :lastname")
    PersonEntity findByName(@Param("name") String name, @Param("lastname") String lastname);
}
