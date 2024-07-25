package com.simple.bank_system.services.account.impl;

import com.simple.bank_system.dtos.account.AccountDto;
import com.simple.bank_system.models.account.AccountModel;
import com.simple.bank_system.repositories.account.AccountRepository;
import com.simple.bank_system.services.account.AccountService;

import java.util.List;

//TODO FAZER O CRUD DE TODOS OS MODELS E ARRUMAR A API.
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public List<AccountModel> findAll() {
        return List.of();
    }

    @Override
    public AccountModel findById(Integer integer) {
        return null;
    }

    @Override
    public AccountModel create(AccountDto accountDto) {
        if (accountRepository.existsById(accountDto.id())) {
            throw new IllegalArgumentException("This User ID already exists.");
        }

        AccountModel accountModel = accountDto.toModel();
        return accountRepository.save(accountModel);
    }

    @Override
    public AccountModel update(Integer integer, AccountDto dto) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }

}
