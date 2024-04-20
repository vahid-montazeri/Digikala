package com.example.digikala.dto;

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

//    @JsonIgnore
    private CategoryDto category;

}
