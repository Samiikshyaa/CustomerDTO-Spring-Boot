package com.metateam.sba.dto.customer;

import com.metateam.sba.entity.Customer;
import com.metateam.sba.enums.AccountType;
import com.metateam.sba.enums.IdType;
import lombok.*;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter

public class CustomerDto {
    private Integer id;

    private String fullName;

    private String mobileNumber;

    private String emailAddress;

    private String address;

    private String googlePlusCode;

    private boolean isPremium;

    private Timestamp dateOfBirth;

    private IdType idType;

    private String idValue;

    private boolean isActive;

    private AccountType accountType;

    public CustomerDto(Integer id) {
        this.id = id;
    }

    public Customer toEntity(CustomerDto customerDto){
        return new Customer().builder()
                .id(customerDto.getId())
                .fullName(customerDto.getFullName())
                .mobileNumber(customerDto.getMobileNumber())
                .emailAddress(customerDto.getEmailAddress())
                .address(customerDto.getAddress())
                .googlePlusCode(customerDto.getGooglePlusCode())
                .isPremium(customerDto.getIsPremium())
                .dateOfBirth(customerDto.getDateOfBirth())
                .idType(customerDto.getIdType())
                .idValue(customerDto.getIdValue())
                .isActive(customerDto.getIsActive())
                .build();
    }

    public Integer getId() {
        return this.id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public String getAddress() {
        return this.address;
    }

    public String getGooglePlusCode() {
        return this.googlePlusCode;
    }

    public boolean getIsPremium() {
        return this.isPremium;
    }

    public Timestamp getDateOfBirth() {
        return this.dateOfBirth;
    }

    public IdType getIdType() {
        return this.idType;
    }

    public String getIdValue() {
        return this.idValue;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public boolean getIsActive() {
        return this.isActive;
    }
}
