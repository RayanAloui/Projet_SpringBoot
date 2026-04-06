package tn.esprit.ds.championnat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.ds.championnat.entities.Contrat;
import tn.esprit.ds.championnat.entities.Equipe;

import java.util.List;

@Repository
public interface ContratRepository extends JpaRepository<Contrat,Long> {
    List<Contrat> findByArchived(boolean archived);
    List<Contrat> findByEquipeAndArchived(Equipe equipe, boolean archived);
}
