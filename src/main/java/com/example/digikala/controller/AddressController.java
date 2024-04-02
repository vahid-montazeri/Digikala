package com.example.digikala.controller;

import com.example.digikala.dto.AddressDto;
import com.example.digikala.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Address")
@AllArgsConstructor

public class AddressController {
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<Void> creat(@RequestBody AddressDto addressDto) {
        addressService.save(addressDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<AddressDto> getById(@PathVariable Long id) {
        AddressDto addressDto = addressService.getById(id);
        return new ResponseEntity<>(addressDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AddressDto>> getAll() {
        List<AddressDto> addressServiceAll = addressService.getAll();
        return new ResponseEntity<>(addressServiceAll, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody AddressDto addressDto) {
        addressService.update(id, addressDto);
        return ResponseEntity.ok("Address With id" + id + "Update Successfully");
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        addressService.deleteById(id);
        return ResponseEntity.ok("Address With id" + id + "Deleted Successfully");
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        addressService.deleteAll();
        return ResponseEntity.ok(null);
    }

}
