package com.lawfinder.backend.Entitity;

import jakarta.persistence.*;

@Entity
@Table(name = "CATEGORY")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private Long categoryId;

    @Column(name = "CATNAME", nullable = false, length = 100)
    private String catName;

    @Column(name = "DESCRIPTION", nullable = false, length = 2000)
    private String description;

    // Constructor, getters and setters

    //Constructor vacio
    public CategoryEntity() {}

    //Constructor con todos los atributos

    public CategoryEntity(String catname, String description){
        this.catName = catname;
        this.description = description;
    }
    
    //Getters 
    public Long getCategoryId() {
        return categoryId;
    }

    public String getCatName() {
        return catName;
    }

    public String getDescription() {
        return description;
    }
    
    // Setters
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
