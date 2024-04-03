package com.example.digikala.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
    private Long accountNumber;

    private Long balance;

    @ManyToOne(fetch = FetchType.LAZY)
    private Buyer buyer;
}
