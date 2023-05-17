package com.lawfinder.backend.dto;

public class ProvinceDto {

    private Long idProvince;
    private String provinceName;
    private int idDepartment;

    public ProvinceDto() {}

    public ProvinceDto(String provinceName, int idDepartment) {
        this.provinceName = provinceName;
        this.idDepartment = idDepartment;
    }

    //getters

    public Long getIdProvince() {
        return idProvince;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    //setters

    public void setIdProvince(Long idProvince) {
        this.idProvince = idProvince;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }
    
}
