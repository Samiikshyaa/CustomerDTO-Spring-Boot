package com.metateam.sba.dto.account;

import com.metateam.sba.entity.Customer;
import com.metateam.sba.enums.AccountType;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class AccountDto {

    private Integer id;

    private String accountNumber;

    private String accountOpenDate;

    private String accountClosedDate;

    private double primaryBalance;

    private double interestAccured;

    private double totalbalance;

    private AccountType accountType;

    private Integer customerId;

    private String customerName;

    private Customer customer;

}
