package com.kafka.controller;

import com.kafka.entity.Account;
import com.kafka.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/account-api")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PutMapping("/account")
    public ResponseEntity<Account> updateAccount(@RequestBody Account account){
        return new ResponseEntity<>(new Account(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAccounts(){
        return new ResponseEntity<>(accountService.getAccounts(), HttpStatus.OK);
    }

    @GetMapping("/account/{id}")
    public  ResponseEntity<Optional<Account>> getAccountById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.OK);
    }
}
