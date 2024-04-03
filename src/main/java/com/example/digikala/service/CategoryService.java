package com.example.digikala.service;

import com.example.digikala.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    void save(CategoryDto categoryDto);

    CategoryDto getById(Long id);

    List<CategoryDto> getAll();

    void update(Long id, CategoryDto categoryDto);

    void deleteById(Long id);

    void deleteAll();
}
