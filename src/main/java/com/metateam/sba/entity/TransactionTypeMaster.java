package com.metateam.sba.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Entity
@Table(name = "tbl_master_transaction_type")
public class TransactionTypeMaster implements Serializable {
    @Id
    @SequenceGenerator(name ="tbl_master_transaction_type_id_sequence", initialValue = 1, sequenceName = "tbl_master_transaction_type_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name="name", length=30)
    private String name;
    @Column(name = "code", length = 10)
    private String code;
}
