package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "course")
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private Long idCourse;

    @Column(nullable = false, length = 100)
    private String emplacement;

    @Column(name = "date_course", nullable = false)
    private LocalDate dateCourse;

    @ManyToMany(mappedBy = "courses")
    private List<Championnat> championnats;

    @OneToMany(mappedBy = "course")
    private List<Position> positions;
}
