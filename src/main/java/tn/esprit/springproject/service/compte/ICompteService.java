package tn.esprit.springproject.service.compte;
import tn.esprit.springproject.entity.Compte;

public interface ICompteService {
    public Compte ajouterCompteEtAffecterAAgence(Compte compte, String agenceBank);
}
