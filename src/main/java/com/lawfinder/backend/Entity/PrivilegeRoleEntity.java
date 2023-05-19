package com.lawfinder.backend.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "PRIVILEGE_ROLE")
public class PrivilegeRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRIVROLE_ID")
    private Long privRoleId;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "PRIVILEGE_ID", referencedColumnName = "PRIVILEGE_ID")
    private PrivilegeEntity privilege;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")
    private RoleEntity role;

    // Constructor
    public PrivilegeRoleEntity() {
    }

    // Constructor con todos los atributos
    public PrivilegeRoleEntity (Long privRoleId ,PrivilegeEntity privilege, RoleEntity role) {
        this.privRoleId = privRoleId;
        this.privilege = privilege;
        this.role = role;
    }

    // Getters y setters

    public Long getPrivRoleId() {
        return privRoleId;
    }

    public void setPrivRoleId(Long privRoleId) {
        this.privRoleId = privRoleId;
    }

    public PrivilegeEntity getPrivilege() {
        return privilege;
    }

    public void setPrivilege(PrivilegeEntity privilege) {
        this.privilege = privilege;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    //toString

    @Override
    public String toString() {
        return "PrivilegeRoleEntity{" +
                "privRoleId=" + privRoleId +
                ", privilege=" + privilege +
                ", role=" + role +
                '}';
    }
}