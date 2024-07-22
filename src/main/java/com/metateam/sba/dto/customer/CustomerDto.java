package com.metateam.sba.dto.customer;

import com.metateam.sba.entity.Customer;
import com.metateam.sba.enums.IdType;
import lombok.*;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

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

    public CustomerDto(Integer id) {
        this.id = id;
    }

    public Customer toEntity(CustomerDto customerDto){
        return new Customer().builder()
                .id(customerDto.getId())
                .fullName(customerDto.getFullName())
                .mobileNumber(customerDto.getMobileNumber())
                .emailAddress(customerDto.getEmailAddress())
                .address(customerDto.getMobileNumber())
                .googlePlusCode(customerDto.getGooglePlusCode())
                .isPremium(customerDto.isPremium())
                .dateOfBirth(customerDto.getDateOfBirth())
                .idType(customerDto.getIdType())
                .idValue(customerDto.getIdValue())
                .isActive(customerDto.isActive())
                .build();
    }
}
