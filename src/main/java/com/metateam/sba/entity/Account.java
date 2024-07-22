package com.metateam.sba.entity;

import com.metateam.sba.enums.AccountType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tbl_account", uniqueConstraints =
    @UniqueConstraint(name="unique_account_number", columnNames = "account_number"))
public class Account implements Serializable {
    @Id
    @SequenceGenerator(name = "tbl_account_id_sequence", initialValue = 1, sequenceName = "tbl_account_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_account_id_sequence")
    private Integer id;
    @Column(name = "account_number", length = 30)
    private String accountNumber;
    @Column(name = "account_open_date")
    private Timestamp accountOpenDate;
    @Column(name = "account_closed_date")
    private Timestamp accountClosedDate;
    @Column(name = "primary_balance")
    private double primaryBalance;
    @Column(name = "interest_accured")
    private double interestAccured;
    @Column(name = "total_balance")
    private double totalbalance;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @OneToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "FK_ACCOUNT_CUSTOMER"))
    private Customer customer;

}
