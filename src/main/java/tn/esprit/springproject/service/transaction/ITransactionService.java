package tn.esprit.springproject.service.transaction;

import tn.esprit.springproject.entity.Transaction;
import tn.esprit.springproject.enums.TypeTransaction;

import java.util.List;

public interface ITransactionService {
    public String ajouterVirement(Transaction transaction);

    public String ajouterRetrait(Transaction transaction);

    public String ajouterVersement(Transaction transaction);

    public void getAllTransactionByDate();

    public List<Transaction> getAllTransactionByBankId(long idBank);

}
