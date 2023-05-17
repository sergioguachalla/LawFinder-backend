package com.lawfinder.backend.dto;

import java.util.Date;

public class UserDto {

    private Long id;

    private String username;

    private String userLastname;

    private String secret;

    private Boolean status;

    private Long personId;

    private Long imageId;

    private String txUser;

    private String txHost;

    private Date txDate;

    public UserDto() {}

    public UserDto(Long id, String username, String userLastname, String secret, Boolean status, Long personId, Long imageId, String txUser, String txHost, Date txDate) {
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
        return "UserDTO{" +
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