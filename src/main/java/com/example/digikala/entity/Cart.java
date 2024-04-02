package com.example.digikala.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "tbl_cart")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Cart extends AbstractEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private Buyer buyer;
}
