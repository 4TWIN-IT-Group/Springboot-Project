package tn.kadem.kadem.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Equipe  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    @Column(name = "Niveau")
    private Niveau niveau;

    @ManyToMany(mappedBy = "equipe")
    @JsonIgnore
    private Set<Etudiant> etudiant;

    @OneToOne

    private DetailEquipe detailEquipe;


}
