package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.CounterpartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounterpartRepository extends JpaRepository<CounterpartEntity,Long> {}