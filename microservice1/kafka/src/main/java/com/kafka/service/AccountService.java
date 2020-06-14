package com.kafka.service;

import com.kafka.entity.Account;
import com.kafka.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAccounts(){
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(Long id){
      return accountRepository.findById(id);
    }

}
