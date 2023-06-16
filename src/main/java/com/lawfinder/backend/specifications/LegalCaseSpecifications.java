package com.lawfinder.backend.specifications;

import java.util.Date;

import org.springframework.data.jpa.domain.Specification;

import com.lawfinder.backend.Entity.ActorEntity;
import com.lawfinder.backend.Entity.CrimeEntity;
import com.lawfinder.backend.Entity.InstanceLegalCaseEntity;
import com.lawfinder.backend.Entity.LegalCaseEntity;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;

public class LegalCaseSpecifications {
    /* 
    public static Specification<LegalCaseEntity> hasUserId(Long userId) {
        return (root, query, cb) -> cb.equal(root.get("user").get("id"), userId);}
    
    */
    /* 
    public static Specification<LegalCaseEntity> hasUserId(Long userId) {
        return (root, query, cb) -> {
            Predicate userPredicate = cb.equal(root.get("user").get("id"), userId);

            // Join con los actores y creación del predicado
            Join<LegalCaseEntity, ActorEntity> actorJoin = root.join("actors");
            Predicate actorPredicate = cb.and(
                cb.equal(actorJoin.get("userId").get("id"), userId),
                cb.isTrue(actorJoin.get("status"))
            );

            // Devuelve un predicado OR que combina userPredicate y actorPredicate
            return cb.or(userPredicate, actorPredicate);
        };
    }*/

    public static Specification<LegalCaseEntity> hasUserId(Long userId) {
    return (root, query, cb) -> {
        Predicate userPredicate = cb.equal(root.get("user").get("id"), userId);

        // Crear una subconsulta para buscar actores
        Subquery<Long> actorSubquery = query.subquery(Long.class);
        Root<ActorEntity> actorRoot = actorSubquery.from(ActorEntity.class);
        actorSubquery.select(actorRoot.get("legalCaseId").get("id"));
        actorSubquery.where(
            cb.and(
                cb.equal(actorRoot.get("userId").get("id"), userId),
                cb.isTrue(actorRoot.get("status"))
            )
        );

        // Crear un predicado que comprueba si el ID de LegalCase está en los resultados de la subconsulta
        Predicate actorPredicate = cb.in(root.get("id")).value(actorSubquery);

        // Devolver un predicado OR que combina userPredicate y actorPredicate
        return cb.or(userPredicate, actorPredicate);
    };
    }


    public static Specification<LegalCaseEntity> startDateBetween(Date from, Date to) {
        return (root, query, cb) -> cb.between(root.get("startDate"), from, to);
    }

    public static Specification<LegalCaseEntity> hasCrime(CrimeEntity crime) {
        return (root, query, cb) -> cb.equal(root.get("crime"), crime);
    }
    // para instancias
    public static Specification<LegalCaseEntity> hasInstance(Long instanceId) {
        return (root, query, cb) -> {
            Join<LegalCaseEntity, InstanceLegalCaseEntity> join = root.join("instanceLegalCases");
            return cb.equal(join.get("instance").get("instanceId"), instanceId);
        };
    }
    // por el estado del caso
    public static Specification<LegalCaseEntity> hasStatus(boolean status) {
        return (root, query, cb) -> cb.equal(root.get("status"), status);
    }

    //Del searcher por titulo
    public static Specification<LegalCaseEntity> titleContains(String keyword) {
        return (root, query, cb) -> cb.like(cb.lower(root.get("title")), "%" + keyword.toLowerCase() + "%");
    }


}
