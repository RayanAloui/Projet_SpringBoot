package tn.esprit.ds.championnat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.ds.championnat.entities.Categorie;
import tn.esprit.ds.championnat.entities.Pilote;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PiloteRepository extends JpaRepository<Pilote,Long> {
    List<Pilote> findByCategorieAndPositionsCourseDateCourseBetween(Categorie categorie, LocalDate start, LocalDate end);
    List<Pilote> findByCategorieOrderByNbPointsTotalDesc(Categorie categorie);
}
