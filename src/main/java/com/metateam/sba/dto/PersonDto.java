package com.metateam.sba.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PersonDto {
    private Integer id;
    private String name;
    private String email;
    private String mobileNumber;
    private List<String> address;
}
