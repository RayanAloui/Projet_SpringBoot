package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCourse;

    @Column(nullable = false)
    private String emplacement;

    @Column(name = "date_course")
    private LocalDate dateCourse;

    // Getters & Setters

    public Long getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Long idCourse) {
        this.idCourse = idCourse;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public LocalDate getDateCourse() {
        return dateCourse;
    }

    public void setDateCourse(LocalDate dateCourse) {
        this.dateCourse = dateCourse;
    }
}
