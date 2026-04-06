package tn.esprit.ds.championnat.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.championnat.entities.Sponsor;
import tn.esprit.ds.championnat.services.ISponsorServices;

import java.util.List;

@Tag(name = "Gestion Sponsor")
@RestController
@AllArgsConstructor
@RequestMapping("/sponsor")
public class SponsorController {
    ISponsorServices sponsorServices;

    @Operation(description = "Ajout d'un sponsor")
    @PostMapping("/add-sponsor")
    public Sponsor addSponsor(@RequestBody Sponsor s){
        return sponsorServices.ajouterSponsor(s);
    }

    @Operation(description = "Ajout de plusieurs sponsors")
    @PostMapping("/add-sponsors")
    public List<Sponsor> addSponsors(@RequestBody List<Sponsor> sponsors)
    {
        return sponsorServices.ajouterSponsors(sponsors);
    }

    @Operation(description = "modification d'un sponsor")
    @PutMapping("/update-sponsor")
    public Sponsor updateSponsor(@RequestBody Sponsor s){
        return sponsorServices.modifierSponsor(s);
    }

    @Operation(description = "supression d'un sponsor")
    @DeleteMapping("/delete-sponsor/{id}")
    public void deleteSponsor(@PathVariable("id") Long id)
    {
        sponsorServices.supprimerSponsor(id);
    }
}
