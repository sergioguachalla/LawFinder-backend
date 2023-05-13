package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entitity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity,Integer>{
}
