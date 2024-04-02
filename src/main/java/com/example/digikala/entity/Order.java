package com.example.digikala.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
    private Long orderNumber;

    private Long priceProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    private Buyer buyer;
}
