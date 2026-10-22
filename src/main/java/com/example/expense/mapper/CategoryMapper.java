package com.example.expense.mapper;

import com.example.expense.dto.CategoryDto;
import com.example.expense.entity.Category;

public class CategoryMapper {

    // Map CategoryDto to Category entity
    public static Category mapToCategory(CategoryDto categoryDto){
        return new Category(
                categoryDto.id(),
                categoryDto.name()
        );
    }

    // Map Category entity to CategoryDto
    public static CategoryDto mapToCategoryDto(Category category){
        return new CategoryDto(
                category.getId(),
                category.getName()
        );
    }
}
