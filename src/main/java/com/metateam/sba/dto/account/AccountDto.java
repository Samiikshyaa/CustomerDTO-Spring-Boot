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
@ToString

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

    private String email;

    private String mobile_number;

    public AccountDto(double totalbalance, String customerName, String email, String mobile_number) {
        this.totalbalance = totalbalance;
        this.customerName = customerName;
        this.email = email;
        this.mobile_number = mobile_number;
    }
}
