package tn.esprit.ds.championnat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.ds.championnat.entities.Position;

import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position,Long> {
    List<Position> findByPiloteLibelleP(String piloteLibelleP);
}
