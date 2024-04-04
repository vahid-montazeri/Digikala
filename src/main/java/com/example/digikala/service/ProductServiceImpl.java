package com.example.digikala.service;

import com.example.digikala.dto.ProductDto;
import com.example.digikala.entity.Product;
import com.example.digikala.mapper.ProductMapper;
import com.example.digikala.repository.ProductRepository;
import com.example.digikala.util.ResourceBundleUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    @Transactional
    public void save(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        productRepository.save(product);

    }

    @Override
    @Transactional
    public ProductDto getById(Long id) {
        Product productEntity = productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, ResourceBundleUtils.getExceptionMessage("product_not_found")
        ));
        return productMapper.toDto(productEntity);
    }

    @Override
    @Transactional
    public List<ProductDto> getAll() {
        List<Product> list = productRepository.findAll();
        return productMapper.toDtos(list);

    }

    @Override
    @Transactional
    public void update(Long id, ProductDto productDto) {
        Product productEntity = productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, ResourceBundleUtils.getExceptionMessage("product_not_found")
        ));
        productMapper.update(productEntity, productDto);
        productRepository.save(productEntity);

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        productRepository.deleteAll();
    }
}
