package com.metateam.sba.repository;

import com.metateam.sba.entity.TransactionTypeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TransactionTypeMasterRepository extends JpaRepository<TransactionTypeMaster,Integer> {
    @Query(value = "select * from tbl_master_transaction_type where code = ?1", nativeQuery = true)
    Optional<TransactionTypeMaster> findByCode(String code);
}
