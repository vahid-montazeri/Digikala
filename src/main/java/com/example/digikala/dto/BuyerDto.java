package com.example.digikala.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BuyerDto extends AbstractDto {
    private String Name;
    private String family;
    private String email;
    private String address;
    private String phoneNumber;
    private String nationalId;
    private String accounts;
    private String orders;
}
