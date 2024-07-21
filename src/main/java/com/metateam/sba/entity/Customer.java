package com.metateam.sba.entity;

import com.metateam.sba.enums.IdType;
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
@Table(name = "tbl_customer", uniqueConstraints = {
        @UniqueConstraint(name = "unique_customer_mobile", columnNames = "mobile_number"),
        @UniqueConstraint(name = "unique_customer_email", columnNames = "email_address")
})

public class Customer implements Serializable {
    @Id
    @SequenceGenerator(name = "tbl_customer_id_sequence", initialValue = 1, sequenceName = "tbl_customer_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_customer_id_sequence")
    private Integer id;

    @Column(name = "full_name", length = 100)
    private String fullName;

    @Column(name = "mobile_number", length = 15)
    private String mobileNumber;

    @Column(name = "email_address", length = 100)
    private String emailAddress;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "google_plus_code", length = 20)
    private String googlePlusCode;

    @Column(name = "is_premium")
    private boolean isPremimum;

    @Column(name = "date_of_birth")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date dateOfBirth;
    private Timestamp timestamp;

    @Enumerated(EnumType.STRING)
    private IdType idType;

    @Column(name = "id_value", length = 30)
    private String idValue;
}
