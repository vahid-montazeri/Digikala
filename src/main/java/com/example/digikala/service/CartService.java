package com.example.digikala.service;

import com.example.digikala.dto.CartDto;

import java.util.List;

public interface CartService {
    void save(CartDto cartDto);

    CartDto getById(Long id);

    List<CartDto> getAll();

    void update(Long id, CartDto ordersDto);

    void deleteById(Long id);

    void deleteAll();
}
