package tn.esprit.ds.championnat.services;

import tn.esprit.ds.championnat.entities.Pilote;

public interface IPiloteServices {
    String addPilote(Pilote p) ;
    public Pilote AffecterPiloteAEquipe(String libP, String libEq);
    void updatePointsAndClassements();
}
