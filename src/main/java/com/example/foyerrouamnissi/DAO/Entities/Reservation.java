package com.example.foyerrouamnissi.DAO.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name="Reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idReservation;
    @Column(name="anneeUniversitaire")
    private Date anneeUniversitaire;
    @Column(name="estVrai")
    private boolean  estVrai;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants;

    @ManyToOne
    @JoinColumn(name = "id_chambre")
    private Chambre chambre;





}
