package com.cognizant.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountControlller {

    @GetMapping("/{number}")
    public String getAccountStatus(@PathVariable("number") String accountNumber) {
        return accountNumber.equals("00987987973432")?"Type : Savings Account, Balance: 1000000":"Account Not Found";
    }

}
