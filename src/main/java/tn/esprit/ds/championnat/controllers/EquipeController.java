package tn.esprit.ds.championnat.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.ds.championnat.entities.Equipe;
import tn.esprit.ds.championnat.services.EquipeServiceImpl;

@RestController
@RequestMapping("/equipe")
@AllArgsConstructor
public class EquipeController {

    private final EquipeServiceImpl equipeService;

    @GetMapping("/add")
    public Equipe addEquipe(@RequestBody Equipe equipe) {
        return equipeService.ajouterEquipe(equipe);
    }
}


