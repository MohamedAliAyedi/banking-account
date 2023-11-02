package tn.esprit.springproject.service.transaction;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entity.Transaction;
import tn.esprit.springproject.repository.TransactionRepository;

import java.util.List;

@Service
@Data
public class TransactionService implements ITransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public String ajouterVirement(Transaction transaction) {
        if (transaction.getType().equals("VIREMENT") && transaction.getCompte().getType().equals("EPARGNE")) {
            return "On ne peut pas faire un virement à partir d’un compte épargne";
        } else if (transaction.getType().equals("VIREMENT") && !transaction.getCompte().getType().equals("EPARGNE") && transaction.getCompte().getSolde() < transaction.getMontant() + 3) {
            return "On ne peut pas faire un virement : Solde insuffisant";
        } else {
            transactionRepository.save(transaction);
            return "VIREMENT de " + transaction.getMontant() + " DT de compte " + transaction.getCompte().getIdClient() + " vers le compte " + transaction.getCompte().getIdClient() + " approuvé avec succès.";
        }
    }

    @Override
    public String ajouterRetrait(Transaction transaction) {
        if (transaction.getType().equals("RETRAIT") && transaction.getCompte().getSolde() < transaction.getMontant() + 2) {
            return "On ne peut pas faire un retrait : Solde insuffisant";
        } else {
            transactionRepository.save(transaction);
            return "RETRAIT de " + transaction.getMontant() + " DT de compte " + transaction.getCompte().getIdClient() + " approuvé avec succès.";
        }
    }



    @Override
    public String ajouterVersement(Transaction transaction) {
        if (transaction.getType().equals("VERSEMENT") && !transaction.getCompte().getType().equals("EPARGNE")) {
            transaction.setMontant(transaction.getMontant() - 2);
            transactionRepository.save(transaction);
            return "VERSEMENT de " + transaction.getMontant() + " DT de compte " + transaction.getCompte().getIdClient() + " vers le compte " + transaction.getCompte().getIdClient() + " approuvé avec succès.";
        } else {
            transactionRepository.save(transaction);
            return "VERSEMENT de " + transaction.getMontant() + " DT de compte " + transaction.getCompte().getIdClient() + " vers le compte " + transaction.getCompte().getIdClient() + " approuvé avec succès.";
        }
    }

    @Override
    @Scheduled(cron = "*/30 * * * * *")
    public void getAllTransactionByDate() {
        List<Transaction> transactions = transactionRepository.findAll();
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    @Override
    public List<Transaction> getAllTransactionByBankId(long idBank) {
        return transactionRepository.findAllByCompte_Bank_IdBank(idBank);
    }


}
