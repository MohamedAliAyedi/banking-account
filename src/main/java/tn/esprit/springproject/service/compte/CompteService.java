package tn.esprit.springproject.service.compte;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entity.Bank;
import tn.esprit.springproject.entity.Compte;
import tn.esprit.springproject.repository.BankRepository;
import tn.esprit.springproject.repository.CompteRepository;

@Service
@Data
public class CompteService implements ICompteService{
    private final CompteRepository  compteRepository;
    private final BankRepository  bankRepository;

    @Autowired
    public CompteService(CompteRepository compteRepository, BankRepository bankRepository) {
        this.compteRepository = compteRepository;
        this.bankRepository = bankRepository;
    }

    @Override
    public Compte ajouterCompteEtAffecterAAgence(Compte compte, String agenceBank) {
        Bank bank = bankRepository.findByAgence(agenceBank);
        System.out.println("bank: ");
        System.out.println(bank);
        compte.setBank(bank);
        return compteRepository.save(compte);
    }
}
