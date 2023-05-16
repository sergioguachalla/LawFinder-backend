package com.lawfinder.backend.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "SE_USER")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "USERNAME", length = 100, nullable = false)
    private String username;

    @Column(name = "USERLASTNAME", length = 100, nullable = false)
    private String userLastname;

    @Column(name = "SECRET", length = 60, nullable = false)
    private String secret;

    @Column(name = "STATUS", nullable = false)
    private Boolean status;

    @Column(name = "PERSON_ID", nullable = false)
    private Long personId;

    @Column(name = "IMAGE_ID", nullable = false)
    private Long imageId;

    @Column(name = "TX_USER", length = 100, nullable = false)
    private String txUser;

    @Column(name = "TX_HOST", length = 100, nullable = false)
    private String txHost;

    @Column(name = "TX_DATE", nullable = false)
    private Date txDate;

    // Constructor vacío
    public UserEntity() {}

    // Getters y setters


    public UserEntity(Long id, String username, String userLastname, String secret, Boolean status, Long personId, Long imageId, String txUser, String txHost, Date txDate) {
        this.id = id;
        this.username = username;
        this.userLastname = userLastname;
        this.secret = secret;
        this.status = status;
        this.personId = personId;
        this.imageId = imageId;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserLastname() {
        return userLastname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public String getTxUser() {
        return txUser;
    }

    public void setTxUser(String txUser) {
        this.txUser = txUser;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userLastname='" + userLastname + '\'' +
                ", secret='" + secret + '\'' +
                ", status=" + status +
                ", personId=" + personId +
                ", imageId=" + imageId +
                ", txUser='" + txUser + '\'' +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                '}';
    }
}
