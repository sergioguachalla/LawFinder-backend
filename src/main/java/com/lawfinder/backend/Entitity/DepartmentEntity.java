package com.lawfinder.backend.Entitity;
import jakarta.persistence.*;
@Entity
@Table(name = "DEPARTMENT")
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPARTMENT_ID")
    private Long departmentId;

    @Column(name = "DEPARTMENT_NAME")
    private String name;

    // Constructor
    public DepartmentEntity() {}
    
    // Constructor con todos los atributos
    public DepartmentEntity(String name){
        this.name = name;
    }

    // Getters
    public Long getDepartmentId() {
        return departmentId;
    }

    public String getName() {
        return name;
    }

    // Setters
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString
    @Override
    public String toString() {
        return "DepartmentEntity [departmentId=" + departmentId + ", name=" + name + "]";
    }
}
