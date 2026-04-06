package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "detail_championnat")
@Data
public class DetailChampionnat {

    @Id
    @Column(length = 50)
    private String code;

    @Column(nullable = false, length = 255)
    private String description;

    @OneToOne(mappedBy = "detailChampionnat")
    private Championnat championnat;

    }
