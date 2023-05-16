package com.lawfinder.backend.Entity;
import jakarta.persistence.*;

@Entity
@Table(name="PROVINCE")
public class ProvinceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROVINCE_ID")
    private Long provinceId;

    @Column(name = "PROVINCE_NAME", length = 100)
    private String provinceName;

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
    private DepartmentEntity department;


    // Constructor
    public ProvinceEntity() {}
    // Constructor con todos los atributos

    public ProvinceEntity(String provinceName, DepartmentEntity department){
        this.provinceName = provinceName;
        this.department = department;
    }
    // Getters

    public Long getProvinceId() {
        return provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public DepartmentEntity getDepartment() {
        return department;
    }

    // Setters

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }

    // toString
    @Override
    public String toString() {
        return "ProvinceEntity [department=" + department + ", provinceId=" + provinceId + ", provinceName="
                + provinceName + "]";
    }





    
}
