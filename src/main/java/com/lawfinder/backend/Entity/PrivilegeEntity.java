package com.lawfinder.backend.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "PRIVILEGE")
public class PrivilegeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRIVILEGE_ID")
    private Long privilegeId;

    @Column(name = "PRIVILEGE", length = 100)
    private String priv;

    @Column(name = "STATUS", length = 1)
    private int status;
    // Constructor
    public PrivilegeEntity() {
    }

    // Constructor con todos los atributos
    public PrivilegeEntity(Long privilegeId, String priv) {
        this.privilegeId = privilegeId;
        this.priv = priv;
    }

    // Getters y setters

    public Long getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Long privilegeId) {
        this.privilegeId = privilegeId;
    }

    public String getPriv() {
        return priv;
    }

    public void setPriv(String priv) {
        this.priv = priv;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    //toString

    @Override
    public String toString() {
        return "PrivilegeEntity{" +
                "privilegeId=" + privilegeId +
                ", priv='" + priv + '\'' +
                '}';
    }

    
}
