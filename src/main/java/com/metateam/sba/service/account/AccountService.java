package com.metateam.sba.service.account;

import com.metateam.sba.dto.account.AccountDto;
import com.metateam.sba.service.GenericService;

public interface AccountService extends GenericService<AccountDto> {
    AccountDto getCurrentBalance(String parameter);
}
