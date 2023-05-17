package com.lawfinder.backend.dto;

public class SubCategoryDto {

    private Long idSubCategory;
    private String subCategoryName;
    private String description;
    private Long idCategory;

    public SubCategoryDto() {}

    public SubCategoryDto(String subCategoryName, Long idCategory, String description) {
        this.subCategoryName = subCategoryName;
        this.idCategory = idCategory;
        this.description = description;
    }

    //getters

    public Long getIdSubCategory() {
        return idSubCategory;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public String getDescription() {
        return description;
    }

    //setters

    public void setIdSubCategory(Long idSubCategory) {
        this.idSubCategory = idSubCategory;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}
