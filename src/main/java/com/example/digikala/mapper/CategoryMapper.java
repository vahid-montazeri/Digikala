package com.example.digikala.mapper;

import com.example.digikala.dto.CategoryDto;
import com.example.digikala.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends BaseMapper<Category, CategoryDto> {
}
