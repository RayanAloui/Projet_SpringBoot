package tn.esprit.ds.championnat.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.championnat.entities.Equipe;
import tn.esprit.ds.championnat.services.EquipeServiceImpl;

@RestController
@RequestMapping("/equipe")
@AllArgsConstructor
@Tag(name = "Equipe Controller", description = "Gestion des équipes du championnat")
public class EquipeController {

    private final EquipeServiceImpl equipeService;

    @Operation(
            summary = "Ajouter une équipe",
            description = "Permet d’ajouter une nouvelle équipe dans la base de données "
                    + "avec son libellé, son nombre total de points et son classement général."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Equipe ajoutée avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PostMapping("/add")
    public Equipe addEquipe(@RequestBody Equipe equipe) {
        return equipeService.ajouterEquipe(equipe);
    }
}