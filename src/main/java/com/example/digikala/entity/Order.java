package com.example.digikala.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tbl_order")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Order extends AbstractEntity {
    @Column(unique = true)
    private Long orderNumber;

    private Long priceProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    private Buyer buyer;
}
