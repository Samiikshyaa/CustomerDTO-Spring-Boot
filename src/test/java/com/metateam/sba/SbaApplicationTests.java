package com.metateam.sba;

import com.metateam.sba.service.account.AccountService;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@Slf4j
@ToString
@SpringBootTest
class SbaApplicationTests {
    @Autowired
    private AccountService accountService;

    @Test
    public void checkService(){
//        accountService.getCurrentBalance("9841396661");

        log.info(accountService.getCurrentBalance("9841396661").toString());
        Assertions.assertNotNull(accountService.getCurrentBalance("9841396661"));
        Assertions.assertEquals(0, accountService.getCurrentBalance("9841396661").getTotalbalance());

    }


}
