package com.lawfinder.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ADDRESS")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDRESS_ID")
    private int addressId;

    @Column(name = "ADDRESSINFO", nullable = false)
    private String addressInfo;

    @Column(name = "PROV_ID", nullable = false)
    private int province;
    /*
    @ManyToOne
    @JoinColumn(name = "PROV_ID", referencedColumnName = "PROVINCE_ID")
    private ProvinceEntity province;
    */
    // Constructor vacío
    public AddressEntity() {}

    public AddressEntity(int addressId, String addressInfo, int province) {
        this.addressId = addressId;
        this.addressInfo = addressInfo;
        this.province = province;
    }

    // Getters y setters

    public int getAddressId() {
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

    public int getProvId() {
        return province;
    }

    public void setProvId(int  province) {
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
