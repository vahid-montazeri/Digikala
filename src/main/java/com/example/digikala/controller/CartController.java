package com.example.digikala.controller;

import com.example.digikala.dto.CartDto;
import com.example.digikala.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Card")
@AllArgsConstructor

public class CartController {
    public CartService cartService;

    @PostMapping
    public ResponseEntity<Void> creat(@RequestBody CartDto cartDto){
        cartService.save(cartDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<CartDto> getById(@PathVariable Long id){
        CartDto cartDto = cartService.getById(id);
        return new ResponseEntity<>(cartDto,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CartDto>> getAll(){
        List<CartDto> cartServiceAll = cartService.getAll();
        return new ResponseEntity<>(cartServiceAll,HttpStatus.OK);
    }
    @PutMapping(path = "{id}")
    public ResponseEntity<String> update(@PathVariable Long id , @RequestBody CartDto cartDto){
        cartService.update(id,cartDto);
        return ResponseEntity.ok("Card with id " + id + " updated successfully");
    }
    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        cartService.deleteById(id);
        return ResponseEntity.ok("Card with id" + id + "delete successfully");

    }
}
