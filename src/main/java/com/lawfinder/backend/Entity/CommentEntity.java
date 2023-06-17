package com.lawfinder.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "COMMENT")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_ID")
    private Long commentId;


    @ManyToOne
    @JoinColumn(name = "ACTOR_ID", referencedColumnName = "ACTOR_ID")
    private ActorEntity actorId;

    @ManyToOne
    @JoinColumn(name = "LEGAL_CASE_ID", referencedColumnName = "LEGAL_CASE_ID")
    private LegalCaseEntity legalCaseId;

    @Column(name = "COMMENT_CONTENT", columnDefinition = "Text")
    private String commentContent;

    // Constructor, getters, and setters
    // ...

    public CommentEntity() {
    }

    public CommentEntity(ActorEntity actorId, LegalCaseEntity legalCaseId, String commentContent) {
        this.actorId = actorId;
        this.legalCaseId = legalCaseId;
        this.commentContent = commentContent;
    }

    // Getters and setters
    // ...


    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public ActorEntity getActorId() {
        return actorId;
    }

    public void setActorId(ActorEntity actorId) {
        this.actorId = actorId;
    }

    public LegalCaseEntity getLegalCaseId() {
        return legalCaseId;
    }

    public void setLegalCaseId(LegalCaseEntity legalCaseId) {
        this.legalCaseId = legalCaseId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
