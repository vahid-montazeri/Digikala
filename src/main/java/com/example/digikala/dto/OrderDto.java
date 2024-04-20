package com.example.digikala.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderDto extends AbstractDto {
    private Long orderNumber;

    private Long priceProduct;

    private BuyerDto buyer;
}
