package tn.esprit.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.springproject.entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
    Bank findByAgence(String agence);
}