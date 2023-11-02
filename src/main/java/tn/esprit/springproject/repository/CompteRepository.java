package tn.esprit.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.springproject.entity.Compte;

import java.util.List;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {

}
