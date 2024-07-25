package com.simple.bank_system.services.account;

import com.simple.bank_system.dtos.account.AccountDto;
import com.simple.bank_system.models.account.AccountModel;
import com.simple.bank_system.services.CRUDService;

public interface AccountService extends CRUDService<Integer, AccountModel, AccountDto> {

}