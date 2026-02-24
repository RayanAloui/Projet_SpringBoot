package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "position")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPosition;

    @Column(nullable = false)
    Integer classement;

    @Column(name = "nb_points", nullable = false)
    Integer nbPoints;

    @ManyToOne
    Course course;

    @ManyToOne
    Pilote pilote;
}