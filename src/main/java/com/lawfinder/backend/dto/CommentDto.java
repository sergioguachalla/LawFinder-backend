package com.lawfinder.backend.dto;

public class CommentDto {

    private Long commentId;

    private Long actorId;

    private Long legalCaseId;

    private String commentContent;

    public CommentDto() {
    }
    public CommentDto(Long commentId, Long actorId, Long legalCaseId, String commentContent) {
        this.commentId = commentId;
        this.actorId = actorId;
        this.legalCaseId = legalCaseId;
        this.commentContent = commentContent;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public Long getLegalCaseId() {
        return legalCaseId;
    }

    public void setLegalCaseId(Long legalCaseId) {
        this.legalCaseId = legalCaseId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
