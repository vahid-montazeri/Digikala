package com.example.digikala.dto;

import com.example.digikala.entity.Buyer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CartDto extends AbstractDto {
    private Buyer buyer;
}
