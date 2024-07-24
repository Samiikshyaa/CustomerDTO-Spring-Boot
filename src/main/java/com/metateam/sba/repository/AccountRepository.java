package com.metateam.sba.repository;

import com.metateam.sba.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Map;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query(nativeQuery = true, value = "select full_name, email_address, mobile_number, ta.total_balance\n" +
            "    from tbl_customer tblc\n" +
            "        inner join tbl_account ta on tblc.id = ta.customer_id\n" +
            "    where (mobile_number=?1 or account_number = ?1)")
//    Object findByMobileNumberorAccountNumber(String parameter)
    Map<String, Object> findByMobileNumberorAccountNumber(String parameter);

}
