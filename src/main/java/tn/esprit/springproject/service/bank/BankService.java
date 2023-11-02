package tn.esprit.springproject.service.bank;

import jakarta.servlet.http.PushBuilder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entity.Bank;
import tn.esprit.springproject.repository.BankRepository;

@Service
@Data
public class BankService implements IBankService {
    private final BankRepository bankRepository;

    @Autowired
    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public Bank ajouterBank(Bank bank) {
        return bankRepository.save(bank);
    }
}
