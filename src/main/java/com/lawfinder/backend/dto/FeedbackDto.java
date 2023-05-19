package com.lawfinder.backend.dto;

public class FeedbackDto {
    private Long feedbackId;
    private String content;
    private UserDto userId;
    private String txUser;
    private String txHost;
    private String txDate;

    public FeedbackDto() {
    }

    public FeedbackDto(Long feedbackId, String content, UserDto userId, String txUser, String txHost, String txDate) {
        this.feedbackId = feedbackId;
        this.content = content;
        this.userId = userId;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Long getFeedbackId() {
        return feedbackId;
    }

    public String getContent() {
        return content;
    }

    public UserDto getUserId() {
        return userId;
    }

    public String getTxUser() {
        return txUser;
    }

    public String getTxHost() {
        return txHost;
    }

    public String getTxDate() {
        return txDate;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUserId(UserDto userId) {
        this.userId = userId;
    }

    public void setTxUser(String txUser) {
        this.txUser = txUser;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    public void setTxDate(String txDate) {
        this.txDate = txDate;
    }

    // toString
    @Override
    public String toString() {
        return "FeedbackDto [content=" + content + ", feedbackId=" + feedbackId + ", txDate=" + txDate + ", txHost="
                + txHost + ", txUser=" + txUser + ", userId=" + userId + "]";
    }
    
}
