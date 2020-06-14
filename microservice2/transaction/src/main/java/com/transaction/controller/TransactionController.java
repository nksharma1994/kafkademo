package com.transaction.controller;

import com.transaction.entity.Transaction;
import com.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction-api")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "TRANSACTION_STATUS";

    @PostMapping("/transaction")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction){
        Transaction transaction1 = transactionService.addTransaction(transaction);
        kafkaTemplate.send(TOPIC, transaction1.getStatus());
        return new ResponseEntity<>(new Transaction(), HttpStatus.OK);
    }
}
