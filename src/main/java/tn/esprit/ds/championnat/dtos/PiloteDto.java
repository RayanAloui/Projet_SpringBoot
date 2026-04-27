package tn.esprit.ds.championnat.dtos;

public class PiloteDto {
    private String libelleP;
    private Integer nbPointsTotal;
    private String libelleC;

    public PiloteDto() {
    }

    public PiloteDto(String libelleP, Integer nbPointsTotal, String libelleC) {
        this.libelleP = libelleP;
        this.nbPointsTotal = nbPointsTotal;
        this.libelleC = libelleC;
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

    public String getLibelleC() {
        return libelleC;
    }

    public void setLibelleC(String libelleC) {
        this.libelleC = libelleC;
    }
}
