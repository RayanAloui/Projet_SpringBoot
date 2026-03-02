package tn.esprit.ds.championnat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ds.championnat.entities.Contrat;

public interface ContratRepository
        extends JpaRepository<Contrat, Long> {
}
