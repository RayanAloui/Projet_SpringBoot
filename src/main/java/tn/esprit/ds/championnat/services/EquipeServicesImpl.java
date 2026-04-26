package tn.esprit.ds.championnat.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entities.Contrat;
import tn.esprit.ds.championnat.entities.Equipe;
import tn.esprit.ds.championnat.repositories.EquipeRepository;
import tn.esprit.ds.championnat.repositories.PositionRepository;

import java.util.HashMap;

@Service
@AllArgsConstructor
public class EquipeServicesImpl implements IEquipeServices{
    private EquipeRepository equipeRepository;
    private PositionRepository positionRepository;

    @Override
    public Equipe ajouterEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @Override
    public HashMap<String, Float> historiqueContratsEquipe(String libelleEquipe) {
        Equipe equipe = equipeRepository.findByLibelle(libelleEquipe);
        HashMap<String, Float> historique = new HashMap<>();
        if (equipe != null && equipe.getContrats() != null) {
            float sommeMontants = 0f;
            for (Contrat contrat : equipe.getContrats()) {
                sommeMontants += contrat.getMontant();
            }
            historique.put(libelleEquipe, sommeMontants);
        }
        return historique;
    }

    @Override
    public Integer nbPointsParPilotesUneEquipeChampionnatPourUneAnne(Long idEquipe, Long idChampionnat, String annee) {
        int anneeInt = Integer.parseInt(annee);
        Integer points = positionRepository.sumPointsByEquipeAndChampionnatAndAnnee(idEquipe, idChampionnat, anneeInt);
        return points != null ? points : 0;
    }
}
