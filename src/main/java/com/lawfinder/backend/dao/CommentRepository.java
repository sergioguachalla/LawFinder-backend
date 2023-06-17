package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {


}
