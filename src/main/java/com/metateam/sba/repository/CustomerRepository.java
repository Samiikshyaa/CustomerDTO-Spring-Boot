package com.metateam.sba.repository;

import com.metateam.sba.entity.Customer;
import com.metateam.sba.enums.IdType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
//    @Query(value = "SELECT * from tbl_customer where id_type = ?1", nativeQuery = true)

    //not used query because of the type cast issue between the query and the enum class
    List<Customer> findCustomerByIdType(IdType idType);

    @Query(value="select * from tbl_customer where is_active = ?1", nativeQuery = true)
    List<Customer> findCustomerByIsActive(boolean isActive);

}
