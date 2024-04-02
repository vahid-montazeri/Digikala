package com.example.digikala.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "tbl_order")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Order extends AbstractEntity {
    private Long orderNumber;

    private Long priceProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    private Buyer buyer;
}
