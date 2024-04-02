package com.example.digikala.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
