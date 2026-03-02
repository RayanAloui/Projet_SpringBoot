package tn.esprit.ds.championnat.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.championnat.entities.Championnat;
import tn.esprit.ds.championnat.entities.Contrat;
import tn.esprit.ds.championnat.entities.DetailChampionnat;
import tn.esprit.ds.championnat.entities.Pilote;
import tn.esprit.ds.championnat.services.IAffectationService;

@RestController
@RequestMapping("/affectation")
@AllArgsConstructor
@Tag(name = "Affectations")
public class AffectationController {

    IAffectationService affectationService;

    @PostMapping("/addChamp")
    public Championnat addChamp(@RequestBody Championnat c) {
        return affectationService.addChampAndAssociatedCourses(c);
    }

    @PostMapping("/addDetail/{idChamp}")
    public DetailChampionnat addDetail(@RequestBody DetailChampionnat dt, @PathVariable long idChamp) {

        return affectationService.AjouterEtAffecterDetailChampionAChampionnat(dt, idChamp);
    }

    @PutMapping("/affectPilote")
    public Pilote affectPilote(@RequestParam String pilote, @RequestParam String equipe) {

        return affectationService.affecterPiloteAEquipe(pilote, equipe);
    }

    @PutMapping("/affectCourse")
    public String affectCourse(@RequestParam Long idCourse, @RequestParam Long idChampionnat) {

        return affectationService.affecterCourseAChampionnat(idCourse, idChampionnat);
    }

    @PostMapping("/addContrat")
    public Contrat addContrat(@RequestBody Contrat c, @RequestParam String equipe, @RequestParam String sponsor, @RequestParam String pays) {

        return affectationService.ajouterContratEtAffecterASponsorEtEquipe(c, equipe, sponsor, pays);
    }

}
