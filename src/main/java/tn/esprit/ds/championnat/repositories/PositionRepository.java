package tn.esprit.ds.championnat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.ds.championnat.entities.Position;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position,Long> {
    List<Position> findByPiloteLibelleP(String piloteLibelleP);

    @Query("SELECT SUM(p.nbPoints) FROM Position p " +
           "JOIN p.course c " +
           "JOIN c.championnats ch " +
           "WHERE p.pilote.equipe.idEquipe = :idEquipe " +
           "AND ch.idChampionnat = :idChampionnat " +
           "AND YEAR(c.dateCourse) = :annee")
    Integer sumPointsByEquipeAndChampionnatAndAnnee(@Param("idEquipe") Long idEquipe, @Param("idChampionnat") Long idChampionnat, @Param("annee") int annee);

    List<Position> findByPiloteLibellePAndCourseDateCourseBetween(String libelleP, LocalDate startDate, LocalDate endDate);
}
