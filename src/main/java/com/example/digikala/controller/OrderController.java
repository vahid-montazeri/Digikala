package com.example.digikala.controller;

import com.example.digikala.dto.OrderDto;
import com.example.digikala.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> Creat(@RequestBody OrderDto orderDto) {
        orderService.save(orderDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<OrderDto> getById(@PathVariable Long id) {
        OrderDto orderDto = orderService.getById(id);
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAll() {
        List<OrderDto> orderServiceAll = orderService.getAll();
        return new ResponseEntity<>(orderServiceAll, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody OrderDto orderDto) {
        orderService.update(id, orderDto);
        return ResponseEntity.ok("Order With id" + id + " update successfully");
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        orderService.deleteById(id);
        return ResponseEntity.ok("Order With id" + id + " deleted successfully");
    }
}
