package tn.esprit.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.springproject.entity.Compte;
import tn.esprit.springproject.entity.Transaction;
import tn.esprit.springproject.service.transaction.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/tansaction")

public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/ajouterVirement")
    public String ajouterVirement(@RequestBody Transaction transaction) {
        return transactionService.ajouterVirement(transaction);
    }
    @PostMapping("/ajouterRetrait")
    public String ajouterRetrait(@RequestBody Transaction transaction) {
        return transactionService.ajouterRetrait(transaction);
    }
    @PostMapping("/ajouterVersement")
    public String ajouterVersement(@RequestBody Transaction transaction) {
        return transactionService.ajouterVersement(transaction);
    }
    @PostMapping("/getAllTransactionByBankId")
    public List<Transaction> getAllTransactionByBankId(@RequestBody long idBank) {
        return transactionService.getAllTransactionByBankId(idBank);
    }

}
