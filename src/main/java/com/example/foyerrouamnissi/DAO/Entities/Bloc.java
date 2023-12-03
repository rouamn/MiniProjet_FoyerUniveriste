package com.example.foyerrouamnissi.DAO.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bloc")
public class Bloc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBloc;


    @Column(name = "nomBloc")
    private String nomBloc;

    @Column(name = "capaciteBloc")
    private long capaciteBloc;


    @ManyToOne
    @JoinColumn(name="id_foyer")
    private Foyer foyer;


    // relation entre bloc et chambres  (parent)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bloc")
    @JsonIgnore
    private Set<Chambre> chambres = new HashSet<>();


    public Bloc (long capaciteBloc)  {
        this.capaciteBloc = capaciteBloc;
    }

    public Bloc(String nomBloc) {
        this.nomBloc = nomBloc;
    }
}

