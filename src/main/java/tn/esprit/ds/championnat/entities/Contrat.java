package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "contrat")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idContrat;

    @Column(nullable = false)
    Float montant;

    @Column(length = 4, nullable = false)
    String annee;

    @Column(nullable = false)
    Boolean archived;

    @ManyToOne
    Equipe equipe;

    @ManyToOne
    Sponsor sponsor;
}