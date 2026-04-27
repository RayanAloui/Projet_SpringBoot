package tn.esprit.ds.championnat.services;


import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entities.Contrat;
import tn.esprit.ds.championnat.entities.Equipe;
import tn.esprit.ds.championnat.repositories.ContratRepository;
import tn.esprit.ds.championnat.repositories.EquipeRepository;

import java.time.LocalDate;
import java.util.List;

import tn.esprit.ds.championnat.dtos.ContratDto;
import tn.esprit.ds.championnat.entities.Sponsor;
import tn.esprit.ds.championnat.repositories.SponsorRepository;

@Service
@AllArgsConstructor
public class ContratServicesImpl implements IContratServices{
    ContratRepository contratRepository;
    EquipeRepository equipeRepository;
    SponsorRepository sponsorRepository;
    
    @Override
    @Scheduled(cron = "0/30 * * * * *")
    public void archiverContratsExpireesEtAffichageContratsActifsParEquipe() {
        Equipe equipe = equipeRepository.findByLibelle("Mercedes");
        List<Contrat> contrats = contratRepository.findByArchived(false);
        List<Contrat> contratsActifs = contratRepository.findByEquipeAndArchived(equipe, false);
        int annee = LocalDate.now().getYear();
        for(Contrat contrat : contratsActifs){
            System.out.println("l'equipe "+equipe.getLibelle()+" a un contrat de montant "+ contrat.getMontant() +" avec le sponsor "+contrat.getSponsor().getNom());
        }
        for (Contrat contrat : contrats) {
            System.out.println(contrat.getAnnee());
            if (Integer.parseInt(contrat.getAnnee()) < annee) {
                contrat.setArchived(true);
                contratRepository.save(contrat);
            }
        }

    }

    @Override
    public ContratDto ajoutContratEtAffecterASponsorEtEquipe(Contrat contrat, String libelleEquipe, String nomSponsor, String pays) {
        Equipe equipe = equipeRepository.findByLibelle(libelleEquipe);
        Sponsor sponsor = sponsorRepository.findByNomAndPays(nomSponsor, pays);

        if (equipe != null && sponsor != null) {
            contrat.setEquipe(equipe);
            contrat.setSponsor(sponsor);
            Contrat savedContrat = contratRepository.save(contrat);

            // Solution manuelle de mapping vers DTO
            ContratDto dto = new ContratDto();
            dto.setIdContrat(savedContrat.getIdContrat());
            dto.setMontant(savedContrat.getMontant());
            dto.setAnnee(savedContrat.getAnnee());
            dto.setLibelleEquipe(savedContrat.getEquipe().getLibelle());
            dto.setNomSponsor(savedContrat.getSponsor().getNom());

            return dto;
        }
        return null;
    }
}
