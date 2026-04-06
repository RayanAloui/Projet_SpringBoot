package tn.esprit.ds.championnat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.ds.championnat.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
}
