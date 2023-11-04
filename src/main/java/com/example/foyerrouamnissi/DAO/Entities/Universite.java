package com.example.foyerrouamnissi.DAO.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@Entity
@Table(name="Universite")
public class Universite  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUniversite;
    @Column(name="nomUniversite")
    private  String nomUniversite;
    @Column(name="adresse")
    private String  adresse;
    //assosiation child
    @OneToOne(mappedBy = "universite")
    private  Foyer foyer;



}
