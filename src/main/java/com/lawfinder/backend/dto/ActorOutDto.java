package com.lawfinder.backend.dto;

public class ActorOutDto {

    private Long actorId;
    private String username;

    public ActorOutDto() {
    }

    public ActorOutDto(Long actorId, String username) {
        this.actorId = actorId;
        this.username = username;
    }

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}


