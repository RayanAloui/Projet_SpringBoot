package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "equipe")
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipe;

    @Column(nullable = false)
    private String libelle;

    @Column(name = "nb_points_total")
    private Integer nbPointsTotal;

    @Column(name = "classement_general")
    private Integer classementGeneral;

    // Getters & Setters

    public Long getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(Long idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getNbPointsTotal() {
        return nbPointsTotal;
    }

    public void setNbPointsTotal(Integer nbPointsTotal) {
        this.nbPointsTotal = nbPointsTotal;
    }

    public Integer getClassementGeneral() {
        return classementGeneral;
    }

    public void setClassementGeneral(Integer classementGeneral) {
        this.classementGeneral = classementGeneral;
    }
}
