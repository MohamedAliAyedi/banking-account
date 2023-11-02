package tn.esprit.springproject.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entity.Compte;
import tn.esprit.springproject.service.compte.CompteService;

@RestController
@RequestMapping("/compte")
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Bad request.", content = @Content),
        @ApiResponse(responseCode = "401", description = "You are unauthorized.", content = @Content),
        @ApiResponse(responseCode = "403", description = "Forbidden.", content = @Content),
        @ApiResponse(responseCode = "404", description = "The Request-URI could not be found.", content = @Content),
        @ApiResponse(responseCode = "415", description = "Unsupported media type.", content = @Content),
        @ApiResponse(responseCode = "429", description = "Too Many Requests.", content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
        @ApiResponse(responseCode = "503", description = "The server is currently unavailable. Please try later.", content = @Content)
})
@Tag(name = "01 - Compte Controller")
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
