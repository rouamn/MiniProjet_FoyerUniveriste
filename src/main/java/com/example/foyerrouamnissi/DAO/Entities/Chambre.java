package com.example.foyerrouamnissi.DAO.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="Chambre")

public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idChambre;

    @Column(name="numeroChambre" ,unique = true)

    private  String numeroChambre;
    @Column(name="TypeChambre")
    private  long  TypeChambre;
    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;


   // chambre 3andha un seul bloc  hia child
    @ManyToOne
    Bloc bloc;


    @OneToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations;



}
