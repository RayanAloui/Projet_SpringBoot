package tn.esprit.ds.championnat.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.championnat.entities.Pilote;
import tn.esprit.ds.championnat.services.PiloteServiceImpl;

@RestController
@RequestMapping("/pilote")
@AllArgsConstructor
public class PiloteController {

    private final PiloteServiceImpl piloteService;

    @GetMapping("/add")
    public String addPilote(@RequestBody Pilote p) {
        return piloteService.addPilote(p);
    }
}

