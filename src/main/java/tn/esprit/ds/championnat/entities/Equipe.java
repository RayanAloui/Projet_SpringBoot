package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.List;

@Entity
@Table(name = "equipe")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEquipe;

    @Column(nullable = false)
    String libelle;

    @Column(name = "nb_points_total")
    Integer nbPointsTotal;

    @Column(name = "classement_general")
    Integer classementGeneral;

    @OneToMany(mappedBy = "equipe")
    List<Pilote> pilotes;

    @OneToMany(mappedBy = "equipe")
    List<Contrat> contrats;
}