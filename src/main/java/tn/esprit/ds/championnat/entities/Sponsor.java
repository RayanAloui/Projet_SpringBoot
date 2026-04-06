package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "sponsor")
@Data
public class Sponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sponsor")
    private Long idSponsor;

    @Column(name = "nom", nullable = false, length = 100)
    private String nom;

    @Column(name = "pays", nullable = false, length = 50)
    private String pays;

    @Column(name = "budget_annuel", nullable = false)
    private Float budgetAnnuel;

    @Column(name = "bloquer_contrat", nullable = false)
    private Boolean bloquerContrat;

    private Boolean archived;
    private LocalDate dateCreation;
    private LocalDate dateDerniereModification;


    @OneToMany(mappedBy = "sponsor")
    private List<Contrat> contrats;

}
