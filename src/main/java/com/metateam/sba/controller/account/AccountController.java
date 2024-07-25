package com.metateam.sba.controller.account;

import com.metateam.sba.controller.BaseClass;
import com.metateam.sba.dto.GlobalApiResponse;
import com.metateam.sba.dto.account.AccountDto;
import com.metateam.sba.service.account.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController extends BaseClass {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/account-number-mobile-number/{number}")
    public ResponseEntity<GlobalApiResponse> getAccount(@PathVariable(value = "number", required = false) String number){
        AccountDto accountDto = accountService.getCurrentBalance(number);
        if (accountDto!=null){
            return new ResponseEntity<>(successResponse("Data fetched successfully",accountDto), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(failureResponse("Data fetch failed",null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
