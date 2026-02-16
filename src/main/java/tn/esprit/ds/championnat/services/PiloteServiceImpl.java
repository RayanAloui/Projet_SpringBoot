package tn.esprit.ds.championnat.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entities.Pilote;
import tn.esprit.ds.championnat.repositories.PiloteRepository;

@Service
@AllArgsConstructor
public class PiloteServiceImpl implements IPiloteService {

    private final PiloteRepository piloteRepository;

    @Override
    public String addPilote(Pilote p) {
        piloteRepository.save(p);
        return "Pilote ajouté avec succès";
    }
}

