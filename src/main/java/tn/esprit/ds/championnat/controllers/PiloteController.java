package tn.esprit.ds.championnat.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.championnat.entities.Pilote;
import tn.esprit.ds.championnat.services.IPiloteServices;

@Tag(name = "Gestion Pilote")
@RestController
@AllArgsConstructor
@RequestMapping("/pilote")
public class PiloteController {

    IPiloteServices piloteServices;

    @Operation(description = "Ajout d'un pilote")
    @PostMapping("/add-pilote")
    public String addPilote(@RequestBody Pilote p) {
        return piloteServices.addPilote(p);
    }
}