package com.lawfinder.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ACTOR")
public class ActorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACTOR_ID")
    private Long actorId;

    @OneToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserEntity userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LEGAL_CASE_ID", nullable = false)
    private LegalCaseEntity legalCaseId;

    @Column(name = "ROLE_CASE")
    private String roleCase;

    // Constructores, getters y setters

    public ActorEntity() {
    }

    public ActorEntity(Long id, UserEntity userId, LegalCaseEntity legalCaseId, String roleCase) {
        this.actorId = id;
        this.userId = userId;
        this.legalCaseId = legalCaseId;
        this.roleCase = roleCase;
    }

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    public LegalCaseEntity getLegalCaseId() {
        return legalCaseId;
    }

    public void setLegalCaseId(LegalCaseEntity legalCaseId) {
        this.legalCaseId = legalCaseId;
    }

    public String getRoleCase() {
        return roleCase;
    }

    public void setRoleCase(String roleCase) {
        this.roleCase = roleCase;
    }
}
