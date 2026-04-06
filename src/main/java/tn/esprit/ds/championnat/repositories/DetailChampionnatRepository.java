package tn.esprit.ds.championnat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.ds.championnat.entities.DetailChampionnat;

@Repository
public interface DetailChampionnatRepository extends JpaRepository<DetailChampionnat,Long> {
}
