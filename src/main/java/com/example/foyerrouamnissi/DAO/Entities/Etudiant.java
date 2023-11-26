package com.example.foyerrouamnissi.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "etudiant")
public class Etudiant  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEtudiant;
    @Column(name = "nomEt")
    private String nomEt;
    @Column(name = "prenomEt")
    private String prenomEt;
    @Column(name = "cin")
    private long cin;
    @Column(name = "ecole")
    private String ecole;
    @Column(name = "dateNaissance")
    private Date dateNaissance; //JJ/MM/YYYY
    @Column(name = "email")
    private String email;

    //child
    @ManyToMany(mappedBy = "etudiants",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Reservation> reservations = new HashSet<>();


}
