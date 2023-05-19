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

    //toString

    @Override
    public String toString() {
        return "PrivilegeEntity{" +
                "privilegeId=" + privilegeId +
                ", priv='" + priv + '\'' +
                '}';
    }

    
}
