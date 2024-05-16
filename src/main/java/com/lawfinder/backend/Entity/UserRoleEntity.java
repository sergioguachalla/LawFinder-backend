package com.lawfinder.backend.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "SE_USER_ROLE")
public class UserRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ROLE_ID")
    private Long userRoleId;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")
    private RoleEntity role;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private UserEntity user;
    @Column(name = "STATUS")
    private Boolean status;

    @Column(name = "TX_USER", length = 50)
    private String tx_user;

    @Column(name = "TX_HOST", length = 50)
    private String tx_host;

    @Column(name = "TX_DATE")
    private Date tx_date;
    // Constructor
    public UserRoleEntity() {
    }

    // Constructor con todos los atributos
    public UserRoleEntity(RoleEntity role, UserEntity user, Boolean status, String tx_user,
                          String tx_host, Date tx_date) {
        this.role = role;
        this.user = user;
        this.status = status;
        this.tx_user = tx_user;
        this.tx_host = tx_host;
        this.tx_date = tx_date;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getTx_user() {
        return tx_user;
    }

    public void setTx_user(String tx_user) {
        this.tx_user = tx_user;
    }

    public String getTx_host() {
        return tx_host;
    }

    public void setTx_host(String tx_host) {
        this.tx_host = tx_host;
    }

    public Date getTx_date() {
        return tx_date;
    }

    public void setTx_date(Date tx_date) {
        this.tx_date = tx_date;
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
