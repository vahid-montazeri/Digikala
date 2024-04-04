package com.example.digikala.controller;

import com.example.digikala.dto.CategoryDto;
import com.example.digikala.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Void> creat(@RequestBody CategoryDto categoryDto) {
        categoryService.save(categoryDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<CategoryDto> getById(@PathVariable Long id) {
        CategoryDto categoryDto = categoryService.getById(id);
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAll( ) {
        List<CategoryDto> accountServiceAll = categoryService.getAll();
        return new ResponseEntity<>(accountServiceAll, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
        categoryService.update(id, categoryDto);
        return ResponseEntity.ok("Category With id" + id + " update successfully");
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        categoryService.deleteById(id);
        return ResponseEntity.ok("Category With id" + id + " deleted successfully");
    }

}
