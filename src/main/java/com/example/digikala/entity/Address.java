package com.example.digikala.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tbl_address")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Address extends AbstractEntity {
    private String state;
    private String city;
    private String avenue;
    private String alley;
    private String houseNumber;
    @Column(unique = true, length = 10)
    private String postalCode;
    @ManyToOne(fetch = FetchType.LAZY)
    private Buyer buyer;

}
