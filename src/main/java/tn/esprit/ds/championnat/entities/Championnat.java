package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "championnat")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Championnat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idChampionnat;

    @Enumerated(EnumType.STRING)
    Categorie categorie;

    @Column(name = "libelle_c", nullable = false)
    String libelleC;

    Integer annee;

    @OneToOne
    DetailChampionnat detailChampionnat;

    @ManyToMany
    List<Course> courses;
}