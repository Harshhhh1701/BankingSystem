package com.example.Banking.app.service.impl;

import com.example.Banking.app.dto.AccountDto;
import com.example.Banking.app.entity.Account;
import com.example.Banking.app.mapper.AccountMapper;
import com.example.Banking.app.repository.AccountRepository;
import com.example.Banking.app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account= AccountMapper.mapToAccount(accountDto);
        Account savedAccount= accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }
}
