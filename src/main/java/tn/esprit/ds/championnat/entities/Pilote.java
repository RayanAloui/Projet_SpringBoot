package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "pilote")
@Data
public class Pilote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pilote")
    private Long idPilote;

    @Column(name = "libelle_p", nullable = false, length = 100)
    private String libelleP;

    @Column(name = "nb_points_total", nullable = false)
    private int nbPointsTotal;

    @Column(name = "classement_general", nullable = false)
    private int classementGeneral;

    @OneToMany(mappedBy = "pilote")
    private List<Position> positions;

    @Enumerated(EnumType.STRING)
    @Column(name="categorie")
    private Categorie categorie;

    @ManyToOne
    private Equipe equipe;

   }
