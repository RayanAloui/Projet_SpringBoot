package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "championnat")
@Data
public class Championnat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_championnat")
    private Long idChampionnat;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categorie categorie;

    @Column(name = "libelle_c", nullable = false, length = 100)
    private String libelleC;

    @Column(nullable = false)
    private Integer annee;

    @OneToOne
    private DetailChampionnat detailChampionnat;

    @ManyToMany
    private List<Course> courses;
}
