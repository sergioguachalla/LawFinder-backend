package com.lawfinder.backend.dto;

public class CategoryDto {

    private Long categoryId;
    private String categoryName;
    private String description;

    // Constructor vacío
    public CategoryDto() {}

    // Constructor con todos los atributos
    public CategoryDto(Long categoryId, String categoryName, String description){
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
    }

    // Getters
    public Long getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // toString
    @Override
    public String toString() {
        return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", description=" + description
                + "]";
    }
}
