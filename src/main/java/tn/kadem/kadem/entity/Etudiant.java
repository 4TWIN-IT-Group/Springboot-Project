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
public class Etudiant extends  BaseEntity {

    private String prenomE;
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Option option;
    @ManyToOne
    private Departement department;
    @ManyToMany
    private Set<Equipe> equipe;
    @OneToMany(mappedBy = "etudiant")
    private Set<Contrat> contrat;

}

