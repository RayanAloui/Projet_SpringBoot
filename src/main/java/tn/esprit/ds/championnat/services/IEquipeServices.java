package tn.esprit.ds.championnat.services;

import tn.esprit.ds.championnat.entities.Equipe;

import java.util.HashMap;

public interface IEquipeServices {
    Equipe ajouterEquipe(Equipe equipe);
    HashMap<String, Float> historiqueContratsEquipe(String libelleEquipe);
    Integer nbPointsParPilotesUneEquipeChampionnatPourUneAnne(Long idEquipe, Long idChampionnat, String annee);
}
