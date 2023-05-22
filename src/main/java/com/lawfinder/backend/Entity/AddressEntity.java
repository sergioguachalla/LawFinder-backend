package com.lawfinder.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ADRESS")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDRESS_ID")
    private Integer addressId;

    @Column(name = "ADRESSINFO", nullable = false)
    private String addressInfo;

    @ManyToOne
    @JoinColumn(name = "PROV_ID", referencedColumnName = "PROVINCE_ID")
    private ProvinceEntity province;

    // Constructor vacío
    public AddressEntity() {}

    public AddressEntity(Integer addressId, String addressInfo, ProvinceEntity province) {
        this.addressId = addressId;
        this.addressInfo = addressInfo;
        this.province = province;
    }

    // Getters y setters

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddressInfo() {
        return addressInfo;
    }


    public void setAddressInfo(String addressInfo) {
        this.addressInfo = addressInfo;
    }

    public ProvinceEntity getProvId() {
        return province;
    }

    public void setProvId(ProvinceEntity province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "AddressEntity{" +
                "addressId=" + addressId +
                ", addressInfo='" + addressInfo + '\'' +
                ", provId=" + province +
                '}';
    }
}
