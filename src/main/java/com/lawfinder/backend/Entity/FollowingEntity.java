package com.lawfinder.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "FOLLOWING")
public class FollowingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOLLOW_ID")
    private Long followId;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    private CategoryEntity categoryId;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "USER_ID", nullable = false)
    private UserEntity userId;

    // Constructor
    public FollowingEntity() {
    }

    // Constructor con todos los atributos
    public FollowingEntity(CategoryEntity categoryId, UserEntity userId) {
        this.categoryId = categoryId;
        this.userId = userId;
    }

    // Getters y setters

    public Long getFollowId() {
        return followId;
    }

    public void setFollowId(Long followId) {
        this.followId = followId;
    }

    public CategoryEntity getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(CategoryEntity categoryId) {
        this.categoryId = categoryId;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }
}
