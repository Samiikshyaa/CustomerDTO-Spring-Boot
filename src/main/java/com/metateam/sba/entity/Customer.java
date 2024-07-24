package com.metateam.sba.entity;

import com.metateam.sba.enums.IdType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

@Builder
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
    private boolean isPremium;

    @Column(name = "date_of_birth")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date dateOfBirth;
    private Timestamp dateOfBirth;

    @Enumerated(EnumType.STRING)
    private IdType idType;

    @Column(name = "id_value", length = 30)
    private String idValue;

    @Column(name = "is_active")
    private boolean isActive = true;

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

    public boolean getIsActive() {
        return this.isActive;
    }
}
