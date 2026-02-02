package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "detail_championnat")
public class DetailChampionnat {

    @Id
    @Column(length = 20)
    private String code;

    @Column(length = 255)
    private String description;

    @OneToOne(mappedBy = "detailChampionnat")
    private Championnat championnat;


    // Getters & Setters

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
