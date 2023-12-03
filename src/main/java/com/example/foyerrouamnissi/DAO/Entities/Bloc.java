package com.example.foyerrouamnissi.DAO.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;



@Entity
@Setter
@Getter
@Table(name = "bloc")
public class Bloc  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBloc;


    @Column(name = "nomBloc")
    private String nomBloc;

    @Column(name = "capaciteBloc")
    private long capaciteBloc;


    @ManyToOne
    @JsonIgnore
    Foyer foyer;


// relation entre bloc et chambres  (parent)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bloc")
    private Set<Chambre> chambres;
}
