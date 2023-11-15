package com.example.foyerrouamnissi.DAO.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name="Reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idReservation;

    @Column(name="anneeUniversitaire")
    private LocalDate anneeUniversitaire;

    @Column(name="estValide")
    private boolean  estValide;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants;

    @ManyToOne
    @JoinColumn(name = "id_chambre")
    private Chambre chambre;





}
