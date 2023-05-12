package com.lawfinder.backend.Entitity;

import jakarta.persistence.*;
@Entity
@Table(name = "SUB_CATEGORY")
public class SubCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUBCATEGORY_ID")
    private Long subCategoryId;

    @Column(name = "SUBCATNAME", nullable = false, length = 100)
    private String subCatName;

    @Column(name = "DESCRIPTION", nullable = false, length = 2000)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    private CategoryEntity category;

    // Constructor
    public SubCategoryEntity() {}

    // Constructor con todos los atributos
    public SubCategoryEntity(String subCatName, String description, CategoryEntity category){
        this.subCatName = subCatName;
        this.description = description;
        this.category = category;
    }

    // Getters

    public Long getSubCategoryId() {
        return subCategoryId;
    }

    public String getSubCatName() {
        return subCatName;
    }

    public String getDescription() {
        return description;
    }

    public CategoryEntity getCategory() {
        return category;
    }
    
    // Setters
    public void setSubCategoryId(Long subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public void setSubCatName(String subCatName) {
        this.subCatName = subCatName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    // toString
    @Override
    public String toString() {
        return "SubCategoryEntity [category=" + category + ", description=" + description + ", subCatName=" + subCatName
                + ", subCategoryId=" + subCategoryId + "]";
    }


    
}
