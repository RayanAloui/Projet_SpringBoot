package tn.esprit.ds.championnat.services;

import tn.esprit.ds.championnat.entities.Pilote;

import java.time.LocalDate;

public interface IPiloteServices {
    String addPilote(Pilote p) ;
    public Pilote AffecterPiloteAEquipe(String libP, String libEq);
    void updatePointsAndClassements();
    Float moyennePositionsEntreDeuxDate(LocalDate startDate, LocalDate endDate, String libelleP);
}
