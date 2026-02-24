package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "detail_championnat")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DetailChampionnat {

    @Id
    @Column(length = 20)
    String code;

    @Column(length = 255)
    String description;

    @OneToOne(mappedBy = "detailChampionnat")
    Championnat championnat;
}