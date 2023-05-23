package com.lawfinder.backend.dto;

public class AddressDto {

    private Integer addressId;

    private String addressInfo;

    private Integer provId;

    public AddressDto() {}

    public AddressDto(Integer addressId, String addressInfo, Integer provId) {
        this.addressId = addressId;
        this.addressInfo = addressInfo;
        this.provId = provId;
    }

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

    //to string

    @Override 
    public String toString() {
        return "AddressDto{" +
                "addressId=" + addressId +
                ", addressInfo='" + addressInfo + '\'' +
                ", provId=" + provId +
                '}';
    }
}
