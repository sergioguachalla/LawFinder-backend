package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entity.CategoryEntity;
import com.lawfinder.backend.Entity.SubCategoryEntity;
import com.lawfinder.backend.dao.CategoryRepository;
import com.lawfinder.backend.dao.SubCategoryRepository;
import com.lawfinder.backend.dto.CategoryDto;
import com.lawfinder.backend.dto.SubCategoryDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryBl {

    private final CategoryRepository categoryRepository;

    private final SubCategoryRepository subCategoryRepository;

    public CategoryBl(CategoryRepository categoryRepository, SubCategoryRepository subCategoryRepository){
        this.categoryRepository = categoryRepository;
        this.subCategoryRepository = subCategoryRepository;
    }

    public List<SubCategoryDto> findAllSubCategoriesByCategoryId(Long idCategory){
        List<SubCategoryDto> subCategoryDtoList = new ArrayList<>();
        List<SubCategoryEntity> subCategoryEntityList = this.subCategoryRepository.findAllSubCategoriesByCategoryId(idCategory);
        for (SubCategoryEntity subCategoryEntity : subCategoryEntityList) {
            CategoryEntity categoryEntity = subCategoryEntity.getCategory();
            SubCategoryDto subCategoryDto = new SubCategoryDto();
            subCategoryDto.setIdSubCategory(subCategoryEntity.getSubCategoryId());
            subCategoryDto.setSubCategoryName(subCategoryEntity.getSubCatName());
            subCategoryDto.setDescription(subCategoryEntity.getDescription());
            subCategoryDto.setIdCategory(categoryEntity.getCategoryId());
            subCategoryDtoList.add(subCategoryDto);
        }
        return subCategoryDtoList;
    }
}
