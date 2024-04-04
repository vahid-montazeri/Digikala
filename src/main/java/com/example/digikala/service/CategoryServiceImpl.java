package com.example.digikala.service;

import com.example.digikala.dto.CategoryDto;
import com.example.digikala.entity.Category;
import com.example.digikala.mapper.CategoryMapper;
import com.example.digikala.repository.CategoryRepository;
import com.example.digikala.util.ResourceBundleUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    @Transactional
    public void save(CategoryDto categoryDto) {
        Category categoryEntity = categoryMapper.toEntity(categoryDto);
        categoryRepository.saveAndFlush(categoryEntity);

    }

    @Override
    @Transactional
    public CategoryDto getById(Long id) {
        Category categoryEntity = categoryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, ResourceBundleUtils.getExceptionMessage("category_not_found")));
        return categoryMapper.toDto(categoryEntity);

    }

    @Override
    @Transactional
    public List<CategoryDto> getAll() {
        List<Category> list = categoryRepository.findAll();
        return categoryMapper.toDtos(list);
    }

    @Override
    @Transactional
    public void update(Long id, CategoryDto categoryDto) {
        Category categoryEntity = categoryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, ResourceBundleUtils.getExceptionMessage("category_not_found")));
        categoryMapper.update(categoryEntity, categoryDto);
        categoryRepository.save(categoryEntity);

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);

    }

    @Override
    @Transactional
    public void deleteAll() {
        categoryRepository.deleteAll();
    }
}
