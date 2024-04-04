package com.example.digikala.service;

import com.example.digikala.dto.OrderDto;
import com.example.digikala.entity.Order;
import com.example.digikala.mapper.OrderMapper;
import com.example.digikala.repository.OrderRepository;
import com.example.digikala.util.ResourceBundleUtils;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private OrderMapper orderMapper;

    @Override
    @Transactional
    public void save(OrderDto ordersDto) {
        Order order = orderMapper.toEntity(ordersDto);
        orderRepository.save(order);
    }

    @Override
    @Transactional
    public OrderDto getById(Long id) {
      Order orderEntity  = orderRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, ResourceBundleUtils.getExceptionMessage("order_not_found")
      ));
        return orderMapper.toDto(orderEntity);
    }


    @Override
    @Transactional
    public List<OrderDto> getAll() {
        List<Order> list = orderRepository.findAll();
        return orderMapper.toDtos(list);

    }

    @Override
    @Transactional
    public void update(Long id, OrderDto ordersDto) {
       Order orderEntity = orderRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,ResourceBundleUtils.getExceptionMessage("order_not_found")
        ));
       orderMapper.update(orderEntity,ordersDto);
       orderRepository.save(orderEntity);


    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        orderRepository.deleteAll();
    }
}
