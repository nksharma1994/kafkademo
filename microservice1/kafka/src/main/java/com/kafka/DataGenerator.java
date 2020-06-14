package com.kafka;

import com.kafka.entity.Account;
import com.kafka.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
@Configuration
public class DataGenerator {

    @Autowired
    private AccountRepository accountRepository;
    /*Initializing the dummy data to use application. Will be removed when implement db*/
    @PostConstruct
    public void init() {
        Account account = new Account();
        account.setName("First Account");
        account.setBalance(100000.00);
        accountRepository.save(account);
    }
}
