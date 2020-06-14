package com.transaction.service;

import com.transaction.dto.AccountDto;
import com.transaction.entity.Transaction;
import com.transaction.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository repository;

    public Transaction addTransaction(Transaction transaction){
        return repository.save(transaction);
    }
}
