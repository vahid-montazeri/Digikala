package com.example.digikala.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tbl_account")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Account extends AbstractEntity {
    @Column(unique = true)
    private Long accountNumber;

    private Long balance;

    @ManyToOne(fetch = FetchType.LAZY)
    private Buyer buyer;
}
