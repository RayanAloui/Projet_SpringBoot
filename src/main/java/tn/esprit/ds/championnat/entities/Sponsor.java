package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "sponsor")
public class Sponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSponsor;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String pays;

    @Column(name = "budget_annuel")
    private Float budgetAnnuel;

    @Column(name = "bloquer_contrat")
    private Boolean bloquerContrat;

    @OneToMany(mappedBy = "sponsor")
    private List<Contrat> contrats;

    // Getters & Setters

    public Long getIdSponsor() {
        return idSponsor;
    }

    public void setIdSponsor(Long idSponsor) {
        this.idSponsor = idSponsor;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Float getBudgetAnnuel() {
        return budgetAnnuel;
    }

    public void setBudgetAnnuel(Float budgetAnnuel) {
        this.budgetAnnuel = budgetAnnuel;
    }

    public Boolean getBloquerContrat() {
        return bloquerContrat;
    }

    public void setBloquerContrat(Boolean bloquerContrat) {
        this.bloquerContrat = bloquerContrat;
    }
}
