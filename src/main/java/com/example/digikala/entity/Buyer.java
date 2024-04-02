package com.example.digikala.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "tbl_buyer")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Buyer extends AbstractEntity {

    private String name;

    private String family;

    private String email;

    @OneToMany(mappedBy = "buyer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Address> addresses;

    @Column(unique = true, length = 11)
    private String phoneNumber;

    @Column(unique = true, length = 10)
    private String nationalCode;

    @OneToMany(mappedBy = "buyer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Account> accounts;

    @OneToMany(mappedBy = "buyer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToMany(mappedBy = "buyer" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private List<Cart> carts;

}
