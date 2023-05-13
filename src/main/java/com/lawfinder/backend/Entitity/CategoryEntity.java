package com.lawfinder.backend.Entitity;

import jakarta.persistence.*;

@Entity
@Table(name = "CATEGORY")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private Long categoryId;

    @Column(name = "CATEGORY_NAME", nullable = false, length = 100)
    private String categoryName;

    @Column(name = "DESCRIPTION", nullable = false, length = 2000)
    private String description;

    //Constructor vacio
    public CategoryEntity() {}

    //Constructor con todos los atributos

    public CategoryEntity(String categoryName, String description){
        this.categoryName = categoryName;
        this.description = description;
    }
    
    //Getters 
    public Long getCategoryId() {
        return categoryId;
    }

    public String getcategoryName() {
        return categoryName;
    }

    public String getDescription() {
        return description;
    }
    
    // Setters
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setcategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // toString
    @Override
    public String toString() {
        return "CategoryEntity [categoryId=" + categoryId + ", categoryName=" + categoryName + ", description=" + description
                + "]";
    }

}
