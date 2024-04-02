package com.example.digikala.mapper;

import com.example.digikala.dto.CartDto;
import com.example.digikala.entity.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper extends BaseMapper<Cart, CartDto> {
}
