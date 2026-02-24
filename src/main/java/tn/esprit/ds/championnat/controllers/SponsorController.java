package tn.esprit.ds.championnat.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.championnat.entities.Sponsor;
import tn.esprit.ds.championnat.services.SponsorServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/sponsor")
@AllArgsConstructor
@Tag(name = "Sponsor Controller", description = "Gestion complète des opérations CRUD liées aux sponsors")
public class SponsorController {

    private final SponsorServiceImpl sponsorService;

    @Operation(
            summary = "Ajouter un sponsor",
            description = "Permet d’ajouter un nouveau sponsor. "
                    + "La date de création est automatiquement initialisée à la date système. "
                    + "Les champs archived et bloquerContrat sont automatiquement mis à false."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Sponsor ajouté avec succès"),
            @ApiResponse(responseCode = "400", description = "Requête invalide")
    })
    @PostMapping("/add")
    public Sponsor addSponsor(@RequestBody Sponsor sponsor) {
        return sponsorService.ajouterSponsor(sponsor);
    }

    @Operation(
            summary = "Ajouter plusieurs sponsors",
            description = "Ajoute une liste de sponsors en une seule requête. "
                    + "Pour chaque sponsor, la dateCreation est initialisée automatiquement "
                    + "et les champs archived et bloquerContrat sont mis à false."
    )
    @PostMapping("/addAll")
    public List<Sponsor> addSponsors(@RequestBody List<Sponsor> sponsors) {
        return sponsorService.ajouterSponsors(sponsors);
    }

    @Operation(
            summary = "Modifier un sponsor",
            description = "Met à jour les informations d’un sponsor existant. "
                    + "La dateDerniereModification est automatiquement initialisée à la date système."
    )
    @PutMapping("/update")
    public Sponsor updateSponsor(@RequestBody Sponsor sponsor) {
        return sponsorService.modifierSponsor(sponsor);
    }

    @Operation(
            summary = "Supprimer un sponsor",
            description = "Supprime définitivement un sponsor de la base de données en utilisant son identifiant."
    )
    @DeleteMapping("/delete/{id}")
    public void deleteSponsor(
            @Parameter(description = "Identifiant unique du sponsor à supprimer", example = "1")
            @PathVariable Long id) {
        sponsorService.supprimerSponsor(id);
    }

    @Operation(
            summary = "Lister tous les sponsors",
            description = "Retourne la liste complète des sponsors enregistrés dans la base de données."
    )
    @GetMapping("/all")
    public List<Sponsor> getAllSponsors() {
        return sponsorService.listSponsors();
    }

    @Operation(
            summary = "Récupérer un sponsor par ID",
            description = "Retourne les informations détaillées d’un sponsor à partir de son identifiant."
    )
    @GetMapping("/{id}")
    public Sponsor getSponsor(
            @Parameter(description = "Identifiant unique du sponsor", example = "1")
            @PathVariable Long id) {
        return sponsorService.recupererSponsor(id);
    }

    @Operation(
            summary = "Archiver un sponsor",
            description = "Met le champ archived à true pour le sponsor correspondant à l’identifiant fourni."
    )
    @PutMapping("/archive/{id}")
    public Boolean archiveSponsor(
            @Parameter(description = "Identifiant du sponsor à archiver", example = "1")
            @PathVariable Long id) {
        return sponsorService.archiverSponsor(id);
    }
}