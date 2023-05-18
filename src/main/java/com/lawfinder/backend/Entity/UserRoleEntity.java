package com.lawfinder.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SE_USER_ROLE")
public class UserRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ROLE__ID")
    private Long userRoleId;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")
    private RoleEntity role;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private UserEntity user;

    // Constructor
    public UserRoleEntity() {
    }

    // Constructor con todos los atributos
    public UserRoleEntity(RoleEntity role, UserEntity user) {
        this.role = role;
        this.user = user;
    }

    // Getters y setters

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    //toString

    @Override
    public String toString() {
        return "UserRoleEntity{" +
                "userRoleId=" + userRoleId +
                ", role=" + role +
                ", user=" + user +
                '}';
    }
}
