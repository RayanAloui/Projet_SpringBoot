package tn.esprit.ds.championnat.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entities.Equipe;
import tn.esprit.ds.championnat.repositories.EquipeRepository;

@Service
@AllArgsConstructor
public class EquipeServicesImpl implements IEquipeServices{
    private EquipeRepository equipeRepository;
    @Override
    public Equipe ajouterEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);

    }
}
