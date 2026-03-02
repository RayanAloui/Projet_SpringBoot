package tn.esprit.ds.championnat.services;

import tn.esprit.ds.championnat.entities.Championnat;
import tn.esprit.ds.championnat.entities.Contrat;
import tn.esprit.ds.championnat.entities.DetailChampionnat;
import tn.esprit.ds.championnat.entities.Pilote;

public interface IAffectationService {

    Championnat addChampAndAssociatedCourses(Championnat c);

    DetailChampionnat
    AjouterEtAffecterDetailChampionAChampionnat(
            DetailChampionnat dt, long idc);

    Pilote affecterPiloteAEquipe(String libP, String libEq);

    String affecterCourseAChampionnat(
            Long idCourse,
            Long idChampionnat);

    Contrat ajouterContratEtAffecterASponsorEtEquipe(
            Contrat c,
            String libE,
            String nomSponsor,
            String pays);
}
