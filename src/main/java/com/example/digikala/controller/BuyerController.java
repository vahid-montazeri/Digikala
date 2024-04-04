package com.example.digikala.controller;

import com.example.digikala.dto.BuyerDto;
import com.example.digikala.service.BuyerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("buyers")
@AllArgsConstructor
public class BuyerController {
    private BuyerService buyerService;

    @PostMapping
    public ResponseEntity<Void> creat(@RequestBody BuyerDto buyerDto) {
        buyerService.save(buyerDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

     @GetMapping(path = "{id}")
    public ResponseEntity<BuyerDto> getById(@PathVariable Long id) {
        BuyerDto buyerDto = buyerService.getById(id);
        return new ResponseEntity<>(buyerDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BuyerDto>> getAll() {
        List<BuyerDto> buyerServiceAll = buyerService.getAll();
        return new ResponseEntity<>(buyerServiceAll, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody BuyerDto buyerDto) {
        buyerService.update(id, buyerDto);
        return ResponseEntity.ok("Buyer With id" + id + " update successfully");
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        buyerService.deleteById(id);
        return ResponseEntity.ok("Buyer With id" + id + " deleted successfully");
    }
}
