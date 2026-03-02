package tn.esprit.ds.championnat.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entities.*;
import tn.esprit.ds.championnat.repositories.*;

@Service
@AllArgsConstructor
public class AffectationServiceImpl
        implements IAffectationService {

    ChampionnatRepository championnatRepo;
    CourseRepository courseRepo;
    DetailChampionnatRepository detailRepo;
    PiloteRepository piloteRepo;
    EquipeRepository equipeRepo;
    SponsorRepository sponsorRepo;
    ContratRepository contratRepo;

    @Override
    public Championnat addChampAndAssociatedCourses(Championnat c) {
        return championnatRepo.save(c);
    }

    @Override
    public DetailChampionnat
    AjouterEtAffecterDetailChampionAChampionnat(DetailChampionnat dt, long idc) {

        Championnat ch = championnatRepo.findById(idc).orElse(null);

        dt = detailRepo.save(dt);

        ch.setDetailChampionnat(dt);
        championnatRepo.save(ch);

        return dt;
    }


    @Override
    public Pilote affecterPiloteAEquipe(String libP, String libEq) {

        Pilote p = piloteRepo.findByLibelleP(libP);
        Equipe e = equipeRepo.findByLibelle(libEq);

        p.setEquipe(e);

        return piloteRepo.save(p);
    }


    @Override
    public String affecterCourseAChampionnat(Long idCourse, Long idChampionnat) {

        Championnat ch = championnatRepo.findById(idChampionnat).orElse(null);

        Course c = courseRepo.findById(idCourse).orElse(null);

        ch.getCourses().add(c);

        championnatRepo.save(ch);

        return "Course affectée au championnat";
    }


    @Override
    public Contrat ajouterContratEtAffecterASponsorEtEquipe(Contrat c, String libE, String nomSponsor, String pays) {

        Equipe e = equipeRepo.findByLibelle(libE);

        Sponsor s = sponsorRepo.findByNomAndPays(nomSponsor, pays);

        c.setEquipe(e);
        c.setSponsor(s);
        c.setArchived(false);

        return contratRepo.save(c);
    }


}
