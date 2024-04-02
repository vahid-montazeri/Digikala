package com.example.digikala.controller;

import com.example.digikala.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Category")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;
}
