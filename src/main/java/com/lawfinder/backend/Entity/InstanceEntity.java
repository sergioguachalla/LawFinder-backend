package com.lawfinder.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "INSTANCE")
public class InstanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INSTANCE_ID")
    private Long instanceId;

    @Column(name = "INSTANCE_NAME", nullable = false, length = 1000)
    private String instanceName;

    // Constructor vacío
    public InstanceEntity() {
    }

    // Constructor con todos los atributos
    public InstanceEntity(String instanceName) {
        this.instanceName = instanceName;
    }

    // Getters
    public Long getInstanceId() {
        return instanceId;
    }

    public String getInstanceName() {
        return instanceName;
    }

    // Setters
    public void setInstanceId(Long instanceId) {
        this.instanceId = instanceId;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    // toString
    @Override
    public String toString() {
        return "InstanceEntity [instanceId=" + instanceId + ", instanceName=" + instanceName + "]";
    }
}