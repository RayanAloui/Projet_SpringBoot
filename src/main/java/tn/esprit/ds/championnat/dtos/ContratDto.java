package tn.esprit.ds.championnat.dtos;

public class ContratDto {
    private Long idContrat;
    private Float montant;
    private String annee;
    private String libelleEquipe;
    private String nomSponsor;

    public ContratDto() {
    }

    public ContratDto(Long idContrat, Float montant, String annee, String libelleEquipe, String nomSponsor) {
        this.idContrat = idContrat;
        this.montant = montant;
        this.annee = annee;
        this.libelleEquipe = libelleEquipe;
        this.nomSponsor = nomSponsor;
    }

    public Long getIdContrat() {
        return idContrat;
    }

    public void setIdContrat(Long idContrat) {
        this.idContrat = idContrat;
    }

    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getLibelleEquipe() {
        return libelleEquipe;
    }

    public void setLibelleEquipe(String libelleEquipe) {
        this.libelleEquipe = libelleEquipe;
    }

    public String getNomSponsor() {
        return nomSponsor;
    }

    public void setNomSponsor(String nomSponsor) {
        this.nomSponsor = nomSponsor;
    }
}
