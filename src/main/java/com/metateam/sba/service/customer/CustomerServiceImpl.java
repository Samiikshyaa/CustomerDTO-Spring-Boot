package com.metateam.sba.service.customer;

import com.metateam.sba.dto.customer.CustomerDto;
import com.metateam.sba.entity.Customer;
import com.metateam.sba.repository.CustomerRepository;
import com.metateam.sba.service.GenericService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CustomerServiceImpl implements GenericService<CustomerDto>, CustomerService {
    private final CustomerRepository customerRepo;

    public CustomerServiceImpl(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public CustomerDto create(CustomerDto customerDto) {
        try {
            log.info("---Starting to create the customer---");
            //dto to entity conversion
            Customer entity = customerDto.toEntity(customerDto);
            entity = customerRepo.save(entity);
            Integer customerId = entity.getId();

//        we should autocreate the account
            log.info("---Ending to create the customer---");
            return new CustomerDto(entity.getId());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public CustomerDto findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public List<CustomerDto> findCustomerWithIdType(String idType) {
        return null;
    }

    @Override
    public List<CustomerDto> findPremiumCustomer(String idType) {
        return null;
    }
}
