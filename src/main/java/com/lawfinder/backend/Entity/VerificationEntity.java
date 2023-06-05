package com.lawfinder.backend.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SE_VERIFICATION")
public class VerificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VERIFICATION_ID")
    private Long verificationId;

    @Column(name = "UUID")
    private String token;


    @Column(name = "EXPIRATION_DATE")
    private Date expirationDate;

    @Column(name = "CODE_HASH")
    private String codeHash;

    @Column(name = "VC_TYPE")
    private String vcType;

    @Column(name = "DEVICE_ID")
    private String deviceId;

    // Constructores, getters y setters

    public VerificationEntity() {
    }

    public VerificationEntity(Long verificationId, String token, Date expirationDate, String codeHash, String vcType, String deviceId) {
        this.verificationId = verificationId;
        this.token = token;
        this.expirationDate = expirationDate;
        this.codeHash = codeHash;
        this.vcType = vcType;
        this.deviceId = deviceId;
    }

    public Long getVerificationId() {
        return verificationId;
    }

    public void setVerificationId(Long verificationId) {
        this.verificationId = verificationId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCodeHash() {
        return codeHash;
    }

    public void setCodeHash(String codeHash) {
        this.codeHash = codeHash;
    }

    public String getVcType() {
        return vcType;
    }

    public void setVcType(String vcType) {
        this.vcType = vcType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
