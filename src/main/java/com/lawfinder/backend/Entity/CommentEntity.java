package com.lawfinder.backend.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "COMMENT")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_ID")
    private Long commentId;


    @ManyToOne
    @JoinColumn(name = "SE_USER_ID", referencedColumnName = "USER_ID")
    private UserEntity userId;

    @ManyToOne
    @JoinColumn(name = "LEGAL_CASE_ID", referencedColumnName = "LEGAL_CASE_ID")
    private LegalCaseEntity legalCaseId;

    @Column(name = "COMMENT_CONTENT", columnDefinition = "Text")
    private String commentContent;


    @Column(name = "COMMENT_DATE")
    private Date commentDate;



    // Constructor, getters, and setters
    // ...

    public CommentEntity() {
    }

    public CommentEntity(Long commentId, UserEntity userId, LegalCaseEntity legalCaseId, String commentContent, Date commentDate) {
        this.commentId = commentId;
        this.userId = userId;
        this.legalCaseId = legalCaseId;
        this.commentContent = commentContent;
        this.commentDate = commentDate;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
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

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }
}
