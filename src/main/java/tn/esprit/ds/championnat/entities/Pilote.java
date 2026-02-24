package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.List;

@Entity
@Table(name = "pilote")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Pilote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPilote;

    @Column(name = "libelle_p", nullable = false)
    String libelleP;

    @Column(name = "nb_points_total")
    Integer nbPointsTotal;

    @Column(name = "classement_general")
    Integer classementGeneral;

    @ManyToOne
    Equipe equipe;

    @OneToMany(mappedBy = "pilote")
    List<Position> positions;
}