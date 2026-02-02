package tn.esprit.ds.championnat.entities;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "championnat")
public class Championnat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChampionnat;

    @Enumerated(EnumType.STRING)
    private Categorie categorie;

    @Column(name = "libelle_c", nullable = false)
    private String libelleC;

    private Integer annee;

    @OneToOne
    private DetailChampionnat detailChampionnat;
    @ManyToMany
    private List<Course> courses;

    // Getters & Setters

    public Long getIdChampionnat() {
        return idChampionnat;
    }

    public void setIdChampionnat(Long idChampionnat) {
        this.idChampionnat = idChampionnat;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getLibelleC() {
        return libelleC;
    }

    public void setLibelleC(String libelleC) {
        this.libelleC = libelleC;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }


}