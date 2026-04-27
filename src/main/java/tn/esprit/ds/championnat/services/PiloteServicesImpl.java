package tn.esprit.ds.championnat.services;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entities.Categorie;
import tn.esprit.ds.championnat.entities.Pilote;
import tn.esprit.ds.championnat.entities.Position;
import tn.esprit.ds.championnat.dtos.PiloteDto;
import tn.esprit.ds.championnat.entities.Championnat;
import tn.esprit.ds.championnat.entities.Course;
import tn.esprit.ds.championnat.repositories.ChampionnatRepository;
import tn.esprit.ds.championnat.repositories.EquipeRepository;
import tn.esprit.ds.championnat.repositories.PiloteRepository;
import tn.esprit.ds.championnat.repositories.PositionRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class PiloteServicesImpl implements IPiloteServices{
    private PiloteRepository piloteRepository;
    private EquipeRepository equipeRepository;
    private PositionRepository positionRepository;
    private ChampionnatRepository championnatRepository;
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
    //@Scheduled(cron = "0/10 * * * * *")
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

    @Override
    public Float moyennePositionsEntreDeuxDate(LocalDate startDate, LocalDate endDate, String libelleP) {
        List<Position> positions = positionRepository.findByPiloteLibellePAndCourseDateCourseBetween(libelleP, startDate, endDate);
        if (positions == null || positions.isEmpty()) {
            return 0f;
        }
        float sum = 0f;
        for (Position p : positions) {
            sum += p.getClassement();
        }
        return sum / positions.size();
    }

    @Override
    public List<PiloteDto> listeWinners(Integer annee) {
        List<Championnat> championnats = championnatRepository.findByAnneeGreaterThan(annee);
        List<PiloteDto> winners = new ArrayList<>();

        for (Championnat championnat : championnats) {
            Map<Pilote, Integer> pointsPilotes = new HashMap<>();

            if (championnat.getCourses() != null) {
                for (Course course : championnat.getCourses()) {
                    if (course.getPositions() != null) {
                        for (Position pos : course.getPositions()) {
                            Pilote pilote = pos.getPilote();
                            int currentPoints = pointsPilotes.getOrDefault(pilote, 0);
                            pointsPilotes.put(pilote, currentPoints + pos.getNbPoints());
                        }
                    }
                }
            }

            Pilote winner = null;
            int maxPoints = -1;

            for (Map.Entry<Pilote, Integer> entry : pointsPilotes.entrySet()) {
                if (entry.getValue() > maxPoints) {
                    maxPoints = entry.getValue();
                    winner = entry.getKey();
                }
            }

            if (winner != null) {
                PiloteDto dto = new PiloteDto();
                dto.setLibelleP(winner.getLibelleP());
                dto.setNbPointsTotal(maxPoints);
                dto.setLibelleC(championnat.getLibelleC());
                winners.add(dto);
            }
        }
        return winners;
    }
}
