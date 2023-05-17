package com.lawfinder.backend.dto;

public class DepartmentDto {
    private Long idDepartment;
    private String departmentName;

    public DepartmentDto() {}

    public DepartmentDto(String departmentName) {
        this.departmentName = departmentName;
 
    }

    //getters

    public Long getIdDepartment() {
        return idDepartment;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    //setters

    public void setIdDepartment(Long idDepartment) {
        this.idDepartment = idDepartment;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
}
