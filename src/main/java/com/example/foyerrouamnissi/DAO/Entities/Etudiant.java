package com.example.foyerrouamnissi.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Entity

@Table(name="Etudiant")
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEtudiant;
    @Column(name="nomEt")
    private  String nomEt;
    @Column(name="prenomEt")
    private  String  prenomEt;
    @Column(name="cin")
    private long cin;
    @Column(name="ecole")
    private String ecole;
    @Column(name="dateNaissance")
    private Date dateNaissance;
    //association
    @ManyToMany(mappedBy = "etudiants",cascade = CascadeType.ALL)
    private Set<Reservation> reservations = new HashSet<>();



}
