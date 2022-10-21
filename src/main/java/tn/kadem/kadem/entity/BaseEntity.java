package tn.kadem.kadem.entity;


import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

}
