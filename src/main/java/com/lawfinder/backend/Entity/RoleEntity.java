package com.lawfinder.backend.Entity;

import jakarta.persistence.*;
@Entity
@Table(name = "ROLE")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private Long roleId;

    @Column(name = "ROLENAME", nullable = false, length = 100)
    private String roleName;

    @Column(name = "STATUS", nullable = false, length = 1)
    private int status;

    // Constructor
    public RoleEntity() {
    }

    // Constructor con todos los atributos
    public RoleEntity(String roleName) {
        this.roleName = roleName;
    }

    // Getters y setters

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    // toString


    public RoleEntity(Long roleId, String roleName, int status) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.status = status;
    }

    @Override
    public String toString() {
        return "RoleEntity{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}

