package com.example.foyerrouamnissi.DAO.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


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



    @OneToOne(cascade = CascadeType.ALL)
    private Foyer foyer;

}
