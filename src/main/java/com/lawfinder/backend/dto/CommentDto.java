package com.lawfinder.backend.dto;

import java.util.Date;

public class CommentDto {

    private Long commentId;

    private Long userId;

    private Long legalCaseId;

    private String commentContent;

    private Date commentDate;

    private String userName;

    public CommentDto() {
    }
    public CommentDto(Long commentId, Long userId, Long legalCaseId, String commentContent,
                      Date commentDate, String userName) {
        this.commentId = commentId;
        this.userId = userId;
        this.legalCaseId = legalCaseId;
        this.commentContent = commentContent;
        this.commentDate = commentDate;
        this.userName = userName;

    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
