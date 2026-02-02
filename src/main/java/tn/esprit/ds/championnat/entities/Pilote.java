package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "pilote")
public class Pilote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPilote;

    @Column(name = "libelle_p", nullable = false)
    private String libelleP;

    @Column(name = "nb_points_total")
    private Integer nbPointsTotal;

    @Column(name = "classement_general")
    private Integer classementGeneral;

    // Getters & Setters

    public Long getIdPilote() {
        return idPilote;
    }

    public void setIdPilote(Long idPilote) {
        this.idPilote = idPilote;
    }

    public String getLibelleP() {
        return libelleP;
    }

    public void setLibelleP(String libelleP) {
        this.libelleP = libelleP;
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
