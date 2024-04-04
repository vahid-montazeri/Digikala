package com.example.digikala.dto;

import com.example.digikala.entity.*;
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

    private List<Address> addresses;

    private String phoneNumber;

    private String nationalCode;

    private List<Account> accounts;

    private List<Order> orders;

    private List<Cart> carts;

}
