package com.example.digikala.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddressDto extends AbstractDto {
    private String state;
    private String city;
    private String avenue;
    private String alley;
    private String houseNumber;
    private String postalCode;
    private BuyerDto buyer;
}
