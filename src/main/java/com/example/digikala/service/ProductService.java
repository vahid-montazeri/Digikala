package com.example.digikala.service;

import com.example.digikala.dto.ProductDto;

import java.util.List;

public interface ProductService {
    void save(ProductDto productDto);

    ProductDto getById(Long id);

    List<ProductDto> getAll();

    void update(Long id, ProductDto productDto);

    void deleteById(Long id);

    void deleteAll();

    List<ProductDto> findAllByInStock(boolean inStock);

}
