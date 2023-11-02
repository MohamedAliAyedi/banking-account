package tn.esprit.springproject.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.springproject.entity.Bank;
import tn.esprit.springproject.service.bank.BankService;

@RestController
@RequestMapping("/bank")
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
@Tag(name = "02 - Bank Controller")
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping
    public Bank createBankController(@RequestBody Bank bank) {
        return bankService.ajouterBank(bank);
    }
}
