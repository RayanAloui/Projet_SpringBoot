package tn.esprit.ds.championnat.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.championnat.entities.Sponsor;
import tn.esprit.ds.championnat.services.ISponsorService;
import tn.esprit.ds.championnat.services.SponsorServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/sponsor")
@AllArgsConstructor
public class SponsorController {

    private final SponsorServiceImpl sponsorService;

    @GetMapping("/add")
    public Sponsor addSponsor(@RequestBody Sponsor sponsor) {
        return sponsorService.ajouterSponsor(sponsor);
    }

    @GetMapping("/addAll")
    public List<Sponsor> addSponsors(@RequestBody List<Sponsor> sponsors) {
        return sponsorService.ajouterSponsors(sponsors);
    }

    @PutMapping("/update")
    public Sponsor updateSponsor(@RequestBody Sponsor sponsor) {
        return sponsorService.modifierSponsor(sponsor);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSponsor(@PathVariable Long id) {
        sponsorService.supprimerSponsor(id);
    }

    @GetMapping("/all")
    public List<Sponsor> getAllSponsors() {
        return sponsorService.listSponsors();
    }

    @GetMapping("/{id}")
    public Sponsor getSponsor(@PathVariable Long id) {
        return sponsorService.recupererSponsor(id);
    }

    @PutMapping("/archive/{id}")
    public Boolean archiveSponsor(@PathVariable Long id) {
        return sponsorService.archiverSponsor(id);
    }
}



