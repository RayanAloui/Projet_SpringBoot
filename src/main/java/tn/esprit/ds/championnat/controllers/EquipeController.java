package tn.esprit.ds.championnat.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.championnat.entities.Equipe;
import tn.esprit.ds.championnat.services.IEquipeServices;

import java.util.HashMap;

@Tag(name = "Gestion Equipe")
@RestController
@AllArgsConstructor
@RequestMapping("/equipe")
public class EquipeController {

    IEquipeServices equipeServices;

    @Operation(description = "Ajout d'une équipe")
    @PostMapping("/add-equipe")
    public Equipe addEquipe(@RequestBody Equipe equipe) {
        return equipeServices.ajouterEquipe(equipe);
    }

    @Operation(description = "Historique des contrats d'une équipe")
    @GetMapping("/historique-contrats/{libelleEquipe}")
    public HashMap<String, Float> historiqueContratsEquipe(@PathVariable String libelleEquipe) {
        return equipeServices.historiqueContratsEquipe(libelleEquipe);
    }

    @Operation(description = "Points des pilotes d'une équipe par championnat et année")
    @GetMapping("/points-pilotes/{idEquipe}/{idChampionnat}/{annee}")
    public Integer nbPointsParPilotesUneEquipeChampionnatPourUneAnne(@PathVariable Long idEquipe, @PathVariable Long idChampionnat, @PathVariable String annee) {
        return equipeServices.nbPointsParPilotesUneEquipeChampionnatPourUneAnne(idEquipe, idChampionnat, annee);
    }
}