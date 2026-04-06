package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "contrat")
@Data
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contrat")
    private Long idContrat;

    @Column(nullable = false)
    private Float montant;

    @Column(nullable = false, length = 4)
    private String annee;

    @Column(nullable = false)
    private Boolean archived = false;

    @ManyToOne
    private Equipe equipe;

    @ManyToOne
    private Sponsor sponsor;
}
