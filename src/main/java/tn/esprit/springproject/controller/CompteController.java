package tn.esprit.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entity.Compte;
import tn.esprit.springproject.service.compte.CompteService;

@RestController
@RequestMapping("/compte")

public class CompteController {

    @Autowired
    private CompteService compteService;

    @PostMapping
    public Compte createCompte(@RequestParam String agenceBank, @RequestBody Compte compte) {
        System.out.println("agenceBank = " + agenceBank);
        try {
            return compteService.ajouterCompteEtAffecterAAgence(compte, agenceBank);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
