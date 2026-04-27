package tn.esprit.ds.championnat.services;

import tn.esprit.ds.championnat.entities.Contrat;

import java.util.List;

public interface IContratServices {
    void archiverContratsExpireesEtAffichageContratsActifsParEquipe();
    tn.esprit.ds.championnat.dtos.ContratDto ajoutContratEtAffecterASponsorEtEquipe(Contrat contrat, String libelleEquipe, String nomSponsor, String pays);
}
