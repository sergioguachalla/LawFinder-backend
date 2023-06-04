package com.lawfinder.backend.dto;

public class LegalFileTypeDto {

    private Long typeId;
    private String name;

    public LegalFileTypeDto() {}

    public LegalFileTypeDto(Long typeId, String name) {
        this.typeId = typeId;
        this.name = name;
    }

    public Long getTypeId() {
        return typeId;
    }

    public String getName() {
        return name;
    }

    //setters

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "LegalTypeDto{" +
                "typeId=" + typeId +
                ", name='" + name + '\'' +
                '}';
    }
    
}
