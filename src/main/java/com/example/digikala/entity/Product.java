package com.example.digikala.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "tbl_product")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product extends AbstractEntity {

    private String name;

    private Double price;

    // موجود در انبار
    private boolean inStock;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

}
