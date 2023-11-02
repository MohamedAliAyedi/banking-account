package tn.esprit.springproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBank")
    private long idBank;

    @Column(name = "nom")
    private String nom;

    @Column(name = "agence")
    private String agence;

    @Column(name = "adresse")
    private String adresse;

     @OneToMany(mappedBy = "bank")
     private List<Compte> comptes;

}
