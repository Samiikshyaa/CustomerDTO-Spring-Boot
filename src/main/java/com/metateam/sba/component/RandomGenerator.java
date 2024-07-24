package com.metateam.sba.component;

import com.metateam.sba.enums.AccountType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class RandomGenerator {
    public String generateAccountNumber(AccountType accountType){
        return accountType.name() + "_" +(String.valueOf(UUID.randomUUID()).substring(0,8).replace("-","")).toUpperCase();
    }

}
