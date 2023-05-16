package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity,Integer>{
}
