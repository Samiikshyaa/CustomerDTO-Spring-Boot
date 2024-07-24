package com.metateam.sba.service.account;

import com.metateam.sba.component.RandomGenerator;
import com.metateam.sba.dto.account.AccountDto;
import com.metateam.sba.entity.Account;
import com.metateam.sba.repository.AccountRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Transactional
@Service
@Slf4j
public class AccountServiceImpl implements AccountService{
    private final AccountRepository accountRepository;
    private final RandomGenerator randomGenerator;
//    private final

    public AccountServiceImpl(AccountRepository accountRepository, RandomGenerator randomGenerator) {
        this.accountRepository = accountRepository;
        this.randomGenerator = randomGenerator;
    }

    @Override
    public AccountDto create(AccountDto accountDto) {
        log.info("CREATING THE ACCOUNT FOR THE CUSTOMER WITH ID {}",accountDto.getCustomer().getId());

        Account account = Account.builder()
                .accountNumber(randomGenerator.generateAccountNumber(accountDto.getAccountType()))
                .accountOpenDate(new Timestamp(new java.util.Date().getTime()))
                .accountClosedDate(null)
                .accountType(accountDto.getAccountType())
                .primaryBalance(0.00)
                .interestAccured(0.00)
                .totalbalance(0.00)
                .customer(accountDto.getCustomer()).build();

        account = accountRepository.save(account);

        log.info("ENDING ACCOUNT CREATE");
        return new AccountDto().builder().id(account.getId()).build();
    }

    @Override
    public List<AccountDto> findAll() {
        return null;
    }

    @Override
    public AccountDto findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public AccountDto getCurrentBalance(String parameter) {
        Map<String, Object> map = accountRepository.findByMobileNumberorAccountNumber(parameter);
        return null;
    }
}
