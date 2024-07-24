package com.metateam.sba.service.customer;

import com.metateam.sba.dto.account.AccountDto;
import com.metateam.sba.dto.customer.CustomerDto;
import com.metateam.sba.entity.Customer;
import com.metateam.sba.enums.IdType;
import com.metateam.sba.repository.CustomerRepository;
import com.metateam.sba.service.GenericService;
import com.metateam.sba.service.account.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CustomerServiceImpl implements GenericService<CustomerDto>, CustomerService {
    private final CustomerRepository customerRepo;
    private final AccountService accountService;

    public CustomerServiceImpl(CustomerRepository customerRepo, AccountService accountService) {
        this.customerRepo = customerRepo;
        this.accountService = accountService;
    }

    @Override
    public CustomerDto create(CustomerDto customerDto) {
        try {
            log.info("---Starting to create the customer---");
            //dto to entity conversion
            Customer entity = customerDto.toEntity(customerDto);
            entity = customerRepo.save(entity);
            Integer customerId = entity.getId();

//        we should auto-create the account on successful save of the customer
            AccountDto accountDto = AccountDto.builder()
                    .accountType(customerDto.getAccountType())
                    .customer(entity)
                    .build();

            accountService.create(accountDto);

            log.info("---Ending to create the customer---");
            CustomerDto c = CustomerDto.builder().id(entity.getId())
                    .fullName(entity.getFullName())
                    .mobileNumber(entity.getMobileNumber())
                    .emailAddress(entity.getEmailAddress())
                    .address(entity.getAddress())
                    .googlePlusCode(entity.getGooglePlusCode())
                    .isPremium(entity.getIsPremium())
                    .idType(entity.getIdType())
                    .idValue(entity.getIdValue())
                    .isActive(entity.getIsActive())
                    .build();
//            return new CustomerDto(entity.getId());
            return c;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<CustomerDto> findAll() {
        List<Customer> entityList = customerRepo.findAll();
        List<CustomerDto> customerdtoList = new ArrayList<>();
        for(Customer entity: entityList){
            CustomerDto c = CustomerDto.builder().id(entity.getId())
                    .fullName(entity.getFullName())
                    .mobileNumber(entity.getFullName())
                    .emailAddress(entity.getEmailAddress())
                    .address(entity.getAddress())
                    .googlePlusCode(entity.getGooglePlusCode())
                    .isPremium(entity.getIsPremium())
                    .idType(entity.getIdType())
                    .idValue(entity.getIdValue())
                    .isActive(entity.getIsActive())
                    .build();
            customerdtoList.add(c);
        }
        return customerdtoList;
    }

    @Override
    public CustomerDto findById(Integer id) {
        Customer entity = customerRepo.findById(id).orElseThrow();
        CustomerDto c = CustomerDto.builder().id(entity.getId())
                .fullName(entity.getFullName())
                .mobileNumber(entity.getFullName())
                .emailAddress(entity.getEmailAddress())
                .address(entity.getAddress())
                .googlePlusCode(entity.getGooglePlusCode())
                .isPremium(entity.getIsPremium())
                .idType(entity.getIdType())
                .idValue(entity.getIdValue())
                .isActive(entity.getIsActive())
                .build();
        return c;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public List<CustomerDto> findCustomerWithIdType(IdType idType) {
        List<Customer> entityList = customerRepo.findCustomerByIdType(idType);
        List<CustomerDto> customerDtoByidType = new ArrayList<>();
        for (Customer entity: entityList) {
            CustomerDto cdto = CustomerDto.builder().id(entity.getId())
                    .fullName(entity.getFullName())
                    .mobileNumber(entity.getFullName())
                    .emailAddress(entity.getEmailAddress())
                    .address(entity.getAddress())
                    .googlePlusCode(entity.getGooglePlusCode())
                    .isPremium(entity.getIsPremium())
                    .idType(entity.getIdType())
                    .idValue(entity.getIdValue())
                    .isActive(entity.getIsActive())
                    .build();
            customerDtoByidType.add(cdto);
        }
        return customerDtoByidType;
    }

    @Override
    public List<CustomerDto> findActiveAndInactiveCustomer(boolean isActive) {
        List<Customer> activeCustomers = customerRepo.findCustomerByIsActive(isActive);
        List<CustomerDto> activeCustomersDto = new ArrayList<>();
        for(Customer entity: activeCustomers){
            CustomerDto activeCustomerDto = CustomerDto.builder().id(entity.getId())
                    .fullName(entity.getFullName())
                    .mobileNumber(entity.getFullName())
                    .emailAddress(entity.getEmailAddress())
                    .address(entity.getAddress())
                    .googlePlusCode(entity.getGooglePlusCode())
                    .isPremium(entity.getIsPremium())
                    .idType(entity.getIdType())
                    .idValue(entity.getIdValue())
                    .isActive(entity.getIsActive())
                    .build();
            activeCustomersDto.add(activeCustomerDto);
        }
        return activeCustomersDto;
    }



}
