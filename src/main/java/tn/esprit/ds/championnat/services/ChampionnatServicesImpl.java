package tn.esprit.ds.championnat.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entities.Championnat;
import tn.esprit.ds.championnat.entities.Equipe;
import tn.esprit.ds.championnat.repositories.ChampionnatRepository;

@Service
@AllArgsConstructor
public class ChampionnatServicesImpl implements IChampionnatServices{
    ChampionnatRepository champRepository;

    @Override
    public Championnat addChampAndAssociatedCourses(Championnat c){
        return champRepository.save(c);
    }
}
