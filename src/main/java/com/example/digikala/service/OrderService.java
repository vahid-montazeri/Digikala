package com.example.digikala.service;

import com.example.digikala.dto.OrderDto;

import java.util.List;

public interface OrderService {
    void save(OrderDto ordersDto);

    OrderDto getById(Long id);

    List<OrderDto> getAll();

    void update(Long id, OrderDto ordersDto);

    void deleteById(Long id);

    void deleteAll();
}
