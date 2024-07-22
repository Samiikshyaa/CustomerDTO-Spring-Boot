package com.metateam.sba.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tbl_account_transactions")
public class Transaction implements Serializable {
    @Id
    @SequenceGenerator(name = "tbl_account_transactions_id_sequence", initialValue = 1, sequenceName = "tbl_account_transactions_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_account_transactions_id_sequence")
    private Integer id;
    @Column(name = "amount")
    private double amount;
    @Column(name = "cashback_applicable")
    private double cashbackApplicable;
    @Column(name ="status")
    private boolean status;

//    many transactions can be of one transaction type
//    eg: 10 transactions can be of the type deposit
    @ManyToOne(targetEntity = TransactionTypeMaster.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_type_id", foreignKey = @ForeignKey(name = "FK_TRANSACTION_TRANSACTIONTYPE"))
    private TransactionTypeMaster transactionType;

    @ManyToOne(targetEntity = Account.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", foreignKey = @ForeignKey(name = "FK_TRANSACTION_ACCOUNT"))
    private Account account;

    @Column(name = "created_date")
    private Date createdDate;
}
