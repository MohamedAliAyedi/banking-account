package tn.esprit.springproject.entity;

import jakarta.persistence.*;
import lombok.*;
import tn.esprit.springproject.enums.TypeCompte;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "compte")
public class Compte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCompte")
    private long idClient;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TypeCompte type;

    @Column(name = "code")
    private long code;

    @Column(name = "solde")
    private double solde;

    @ManyToOne
    private Bank bank;

    @OneToMany(mappedBy = "compte")
    private List<Transaction> transactions;



}
