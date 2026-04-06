package tn.esprit.ds.championnat.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.championnat.entities.Equipe;
import tn.esprit.ds.championnat.services.IEquipeServices;

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
}