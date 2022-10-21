package tn.kadem.kadem.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    @Column(name = "Niveau")
    private Niveau niveau;

    @ManyToMany(mappedBy = "equipe")
    private Set<Etudiant> etudiant;

    @OneToOne
    private DetailEquipe detailEquipe;


}
