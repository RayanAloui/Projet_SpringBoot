package tn.esprit.ds.championnat.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.championnat.entities.Pilote;
import tn.esprit.ds.championnat.services.IPiloteServices;

import java.time.LocalDate;

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

    @Operation(description = "Moyenne des positions d'un pilote entre deux dates")
    @GetMapping("/moyenne-positions/{startDate}/{endDate}/{libelleP}")
    public Float moyennePositionsEntreDeuxDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @PathVariable String libelleP) {
        return piloteServices.moyennePositionsEntreDeuxDate(startDate, endDate, libelleP);
    }
}