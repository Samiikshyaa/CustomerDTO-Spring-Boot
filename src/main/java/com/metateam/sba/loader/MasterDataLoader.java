package com.metateam.sba.loader;

import com.metateam.sba.entity.TransactionTypeMaster;
import com.metateam.sba.repository.TransactionTypeMasterRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class MasterDataLoader {
    @Autowired
    private TransactionTypeMasterRepository transactionTypeMasterRepo;


    //    ==============================================================================================
    @PostConstruct
    public void loadData() {
        System.out.println("Running just after application starts");
        System.out.println("Running just after application starts");
        System.out.println("Running just after application starts");
        System.out.println("Running just after application starts");
        createTransactionTypeIfNotFound();
    }

    private void createTransactionTypeIfNotFound() {
        List<TransactionTypeMaster> transactionTypeList = new ArrayList<>();
        transactionTypeList.add(new TransactionTypeMaster().builder().name("Deposit").code("DEP").build());
        transactionTypeList.add(new TransactionTypeMaster().builder().name("Withdraw").code("WD").build());
        transactionTypeList.add(new TransactionTypeMaster().builder().name("Fund Transfer").code("IBFT").build());
        transactionTypeList.add(new TransactionTypeMaster().builder().name("Merchant Type").code("TopUp").build());

        /* Find by name in the database
         * If it does not exist, save the entity
         * If already  exists, do nothing
         */
        for (TransactionTypeMaster transactionType : transactionTypeList) {
            String code = transactionType.getCode();
            Optional<TransactionTypeMaster> optionalTransactionType = transactionTypeMasterRepo.findByCode(code);
            if (!optionalTransactionType.isPresent()) {
                transactionTypeMasterRepo.save(transactionType);
                log.info("SAVE TRANSACTION TYPE WITH CODE {}",code);
            } else {
                log.info("ALREADY EXIST WITH CODE {}", code);
            }


        }

    }
    //    ==============================================================================================
}
