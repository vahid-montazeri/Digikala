package com.example.digikala.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "tbl_category")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Category extends AbstractEntity {

    private String title;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Product> products;
}
