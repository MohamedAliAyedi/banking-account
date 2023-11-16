package tn.esprit.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.springproject.entity.Bank;
import tn.esprit.springproject.service.bank.BankService;

@RestController
@RequestMapping("/bank")

public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping
    public Bank createBankController(@RequestBody Bank bank) {
        return bankService.ajouterBank(bank);
    }
}
