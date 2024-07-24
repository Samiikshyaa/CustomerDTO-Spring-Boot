package com.metateam.sba.service.customer;

import com.metateam.sba.dto.customer.CustomerDto;
import com.metateam.sba.enums.IdType;
import com.metateam.sba.service.GenericService;

import java.util.List;

public interface CustomerService extends GenericService<CustomerDto> {
    List<CustomerDto> findCustomerWithIdType(IdType idType);
    List<CustomerDto> findActiveAndInactiveCustomer(boolean isActive);
}
