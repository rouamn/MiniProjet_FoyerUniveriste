package com.example.foyerrouamnissi.DAO.Entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="Bloc")
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBloc;
    @Column(name="nomBloc")
    private  String nomBloc;
    @Column(name="capaciteBloc")
    private  long  capaciteBloc;
    @ManyToOne
     Foyer foyer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="bloc")
    private Set<Chambre> chambres;

}
