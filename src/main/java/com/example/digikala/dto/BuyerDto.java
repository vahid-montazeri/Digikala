package com.example.digikala.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BuyerDto extends AbstractDto {

    private String name;

    private String family;

    private String email;

    private List<AddressDto> addresses;

    private String phoneNumber;

    private String nationalCode;

    private List<AccountDto> accounts;

    private List<OrderDto> orders;

    private List<CartDto> carts;

}
