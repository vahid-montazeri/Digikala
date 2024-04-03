package com.example.digikala.mapper;

import com.example.digikala.dto.OrderDto;
import com.example.digikala.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper extends BaseMapper<Order, OrderDto> {
}
