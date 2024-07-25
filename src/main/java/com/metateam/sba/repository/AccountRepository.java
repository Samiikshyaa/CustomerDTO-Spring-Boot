package com.metateam.sba.repository;

import com.metateam.sba.dto.account.AccountDto;
import com.metateam.sba.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Map;

public interface AccountRepository extends JpaRepository<Account, Integer> {
//    @Query(nativeQuery = true, value = "select full_name, email_address, mobile_number, ta.total_balanceta.total_balance
//            "    from tbl_customer tblc\n" +
//            "        inner join tbl_account ta on tblc.id = ta.customer_id\n" +
//            "    where (mobile_number=?1 or account_number = ?1)")
//    Object findByMobileNumberorAccountNumber(String parameter)
//    Map<String, Object> findByMobileNumberorAccountNumber(String parameter);  //for test

    @Query(value = "select new com.metateam.sba.dto.account.AccountDto( ta.totalbalance, tblc.fullName, tblc.emailAddress, tblc.mobileNumber) \n" +
            "    from Customer tblc\n" +
            "        inner join Account ta on tblc.id = ta.customer.id\n" +
            "    where (tblc.mobileNumber=?1 or ta.accountNumber = ?1)")

    AccountDto findByMobileNumberOrAccountNumber(String parameter);




}
