package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "positions")
@Data
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_position")
    private Long idPosition;

    @Column(name = "classement", nullable = false)
    private int classement;

    @Column(name = "nb_points", nullable = false)
    private int nbPoints;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Pilote pilote;

}
