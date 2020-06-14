package com.third.microservices.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calling-third-party-api")
public class MyController {

    @GetMapping("/mock-api")
    public ResponseEntity<Boolean> callingMockService(){
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
}
