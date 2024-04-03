package com.example.digikala.dto;

import com.example.digikala.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductDto extends AbstractDto {

    private String name;

    private Double price;

    // موجود در انبار
    private boolean inStock;

    private Category category;

}
