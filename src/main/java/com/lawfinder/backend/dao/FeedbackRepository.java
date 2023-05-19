package com.lawfinder.backend.dao;
import com.lawfinder.backend.Entity.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<FeedbackEntity,Long> {
}
