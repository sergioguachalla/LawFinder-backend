package com.lawfinder.backend.dto;

public class ProvinceDto {

    private Long idProvince;
    private String provinceName;
    private Long idDepartment;

    public ProvinceDto() {}

    public ProvinceDto(Long idProvince, String provinceName, Long idDepartment) {
        this.idProvince = idProvince;
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

    public Long getIdDepartment() {
        return idDepartment;
    }

    //setters

    public void setIdProvince(Long idProvince) {
        this.idProvince = idProvince;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public void setIdDepartment(Long idDepartment) {
        this.idDepartment = idDepartment;
    }
    
}
