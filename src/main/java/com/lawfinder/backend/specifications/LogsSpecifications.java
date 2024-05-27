package com.lawfinder.backend.specifications;

import com.lawfinder.backend.Entity.ApplicationLogEntity;
import com.lawfinder.backend.Entity.LogLevelEntity;
import com.lawfinder.backend.Entity.SecurityLogEntity;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class LogsSpecifications {

    public static Specification<ApplicationLogEntity> startDateBetween(Date from, Date to) {
        return (root, query, cb) -> cb.between(root.get("date"), from, to);
    }

    public static Specification<ApplicationLogEntity> hasLogLevel(Long levelId) {
        return (root, query, cb) -> {
            Join<ApplicationLogEntity, LogLevelEntity> levelJoin = root.join("level");
            return cb.equal(levelJoin.get("levelId"), levelId);
        };
    }

    public static Specification<ApplicationLogEntity> hasCategory(Long categoryId) {
        return (root, query, cb) -> {
            Join<ApplicationLogEntity, LogLevelEntity> categoryJoin = root.join("category");
            return cb.equal(categoryJoin.get("categoryId"), categoryId);
        };
    }


    //Security specifications
    public static Specification<SecurityLogEntity> startDateBetweenSecurity(Date from, Date to) {
        return (root, query, cb) -> cb.between(root.get("date"), from, to);
    }
    public static Specification<SecurityLogEntity> hasCategorySecurity(Long categoryId) {
        return (root, query, cb) -> {
            Join<SecurityLogEntity, LogLevelEntity> categoryJoin = root.join("category");
            return cb.equal(categoryJoin.get("categoryId"), categoryId);
        };
    }


}
