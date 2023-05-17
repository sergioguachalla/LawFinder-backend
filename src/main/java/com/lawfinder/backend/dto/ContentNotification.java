package com.lawfinder.backend.dto;

public class ContentNotification {
    private Long contentNotifId;
    private String body;

    public ContentNotification() {
    }

    public ContentNotification(Long contentNotifId, String body) {
        this.contentNotifId = contentNotifId;
        this.body = body;
    }

    //getters

    


    public Long getcontentNotifId() {
        return contentNotifId;
    }

    public String getBody() {
        return body;
    }

    //setters

    public void setcontentNotifId(Long contentNotifId) {
        this.contentNotifId = contentNotifId;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
