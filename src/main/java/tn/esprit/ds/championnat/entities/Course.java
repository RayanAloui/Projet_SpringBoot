package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "course")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCourse;

    @Column(nullable = false)
    String emplacement;

    @Column(name = "date_course")
    LocalDate dateCourse;

    @ManyToMany(mappedBy = "courses")
    List<Championnat> championnats;

    @OneToMany(mappedBy = "course")
    List<Position> positions;
}