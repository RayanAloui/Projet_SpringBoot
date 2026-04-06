package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "equipe")
@Data
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipe")
    private Long idEquipe;

    @Column(nullable = false, length = 100)
    private String libelle;

    @Column(name = "nb_points_total", nullable = false)
    private int nbPointsTotal;

    @Column(name = "classement_general", nullable = false)
    private int classementGeneral;

    @OneToMany(mappedBy = "equipe")
    private List<Pilote> pilotes;

    @OneToMany(mappedBy = "equipe")
    private List<Contrat> contrats;
}
