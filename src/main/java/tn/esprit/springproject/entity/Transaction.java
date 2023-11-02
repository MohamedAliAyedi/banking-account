package tn.esprit.springproject.entity;

import jakarta.persistence.*;
import lombok.*;
import tn.esprit.springproject.enums.TypeTransaction;

import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTransaction")
    private long idTransaction;

    @Column(name = "montant")
    private double montant;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TypeTransaction type;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "idCompte")
    private Compte compte;
}
