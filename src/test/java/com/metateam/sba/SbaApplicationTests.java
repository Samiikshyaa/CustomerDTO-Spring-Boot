package com.metateam.sba;

import com.metateam.sba.service.account.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SbaApplicationTests {
    @Autowired
    private AccountService accountService;

    @Test
    public void checkService(){
        accountService.getCurrentBalance("9841396661");
    }

}
