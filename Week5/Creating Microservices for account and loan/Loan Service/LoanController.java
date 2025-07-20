package com.cognizant.loan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @GetMapping("/{accountNumber}")
    public  String loan(@PathVariable String accountNumber) {
        return accountNumber.equals("H00987987973432") ?"type:Car Loan, Amount: 500000, EMI: 10000, Tenure: 5 years, Status: Approved":
            "Loan Not Approved for Account Number: " + accountNumber;
    }
}
