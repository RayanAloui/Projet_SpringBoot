package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "sponsor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Sponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idSponsor;

    @Column(nullable = false)
    String nom;

    @Column(nullable = false)
    String pays;

    @Column(name = "budget_annuel")
    Float budgetAnnuel;

    @Column(name = "bloquer_contrat")
    Boolean bloquerContrat;

    @OneToMany(mappedBy = "sponsor")
    List<Contrat> contrats;

    Boolean archived;
    LocalDate dateCreation;
    LocalDate dateDerniereModification;
}