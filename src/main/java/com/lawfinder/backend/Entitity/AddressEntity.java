package com.lawfinder.backend.Entitity;

import jakarta.persistence.*;

@Entity
@Table(name = "ADDRESS")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDRESS_ID")
    private Integer addressId;

    @Column(name = "ADRESSINFO", length = 1000, nullable = false)
    private String addressInfo;

    @Column(name = "PROV_ID", nullable = false)
    private Integer provId;

    // Constructor vacío
    public AddressEntity() {}

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

    public Integer getProvId() {
        return provId;
    }

    public void setProvId(Integer provId) {
        this.provId = provId;
    }
}
