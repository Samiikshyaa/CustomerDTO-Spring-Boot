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
@Table(name = "tbl_account")
public class Account implements Serializable {
    @Id
    @SequenceGenerator(name = "tbl_account_id_sequence", initialValue = 1, sequenceName = "tbl_account_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_account_id_sequence")
    private Integer id;

    private String accountNumber;
    private Timestamp accountOpenDate;
    private Timestamp accountClosedDate;
    private double balance;
    private AccountType accountType;

}
