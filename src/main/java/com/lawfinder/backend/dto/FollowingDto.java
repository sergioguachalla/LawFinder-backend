package com.lawfinder.backend.dto;

public class FollowingDto {
    private Long followId;
    private int categoryId;
    private int userId;

    public FollowingDto() {}

    public FollowingDto(Long followId, int categoryId, int userId) {
        this.followId = followId;
        this.categoryId = categoryId;
        this.userId = userId;
    }

    public Long getFollowId() {
        return followId;
    }

    public void setFollowId(Long followId) {
        this.followId = followId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "FollowingDto{" +
                "followId=" + followId +
                ", categoryId=" + categoryId +
                ", userId=" + userId +
                '}';
    }
}
