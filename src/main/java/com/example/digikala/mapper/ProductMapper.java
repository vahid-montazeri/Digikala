package com.example.digikala.mapper;

import com.example.digikala.dto.ProductDto;
import com.example.digikala.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends BaseMapper<Product, ProductDto> {
}
