package tn.esprit.ds.championnat.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.championnat.entities.Pilote;
import tn.esprit.ds.championnat.services.PiloteServiceImpl;

@RestController
@RequestMapping("/pilote")
@AllArgsConstructor
@Tag(name = "Pilote Controller", description = "Gestion des pilotes")
public class PiloteController {

    private final PiloteServiceImpl piloteService;

    @Operation(summary = "Ajouter un pilote",
            description = "Ajoute un nouveau pilote dans la base de données")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pilote ajouté avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PostMapping("/add")
    public String addPilote(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Objet Pilote à ajouter",
                    required = true
            )
            @RequestBody Pilote p) {

        return piloteService.addPilote(p);
    }
}