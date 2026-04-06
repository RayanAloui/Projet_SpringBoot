package tn.esprit.ds.championnat.services;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entities.Categorie;
import tn.esprit.ds.championnat.entities.Pilote;
import tn.esprit.ds.championnat.entities.Position;
import tn.esprit.ds.championnat.repositories.EquipeRepository;
import tn.esprit.ds.championnat.repositories.PiloteRepository;
import tn.esprit.ds.championnat.repositories.PositionRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class PiloteServicesImpl implements IPiloteServices{
    private PiloteRepository piloteRepository;
    private EquipeRepository equipeRepository;
    private PositionRepository positionRepository;
    @Override
    public String addPilote(Pilote p) {
        piloteRepository.save(p);
        return "Pilote ajouté!";
    }

    @Override
    public Pilote AffecterPiloteAEquipe(String libP, String libEq){
        Pilote p= new Pilote();
        return p;
    }
    @Override
    //@Scheduled(cron="0 15 11 31 12 *")
    @Scheduled(cron = "0/10 * * * * *")
    public void updatePointsAndClassements(){
        int position = 1;
        LocalDate start = LocalDate.of(LocalDate.now().getYear(),1,1);
        LocalDate end = LocalDate.of(LocalDate.now().getYear(),12,31);
        List<Pilote> pilotes = piloteRepository.findByCategorieAndPositionsCourseDateCourseBetween(Categorie.FORMULA1, start,end);

        for (Pilote p : pilotes) {
            int points=0;
            List<Position> positions = positionRepository.findByPiloteLibelleP(p.getLibelleP());
            for (Position pp : positions) {
                points+=pp.getNbPoints();
            }
            p.setNbPointsTotal(points);
            piloteRepository.save(p);
        }
        List<Pilote> pilotesOrd = piloteRepository.findByCategorieOrderByNbPointsTotalDesc(Categorie.FORMULA1);
    for (Pilote p : pilotesOrd) {
        p.setClassementGeneral(position);
        position++;
        piloteRepository.save(p);
    }
    }
}
