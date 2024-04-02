package com.example.digikala.dto;

import com.example.digikala.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CategoryDto extends AbstractDto {

    private String title;

    private List<Product> products;
}
