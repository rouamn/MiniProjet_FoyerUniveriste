package com.example.foyerrouamnissi.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="Foyer")
public class Foyer {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long idFoyer;
        @Column(name="nomFoyer")
        private  String nomFoyer;
        @Column(name="capaciteFoyer")
        private  long  capaciteFoyer;
        //association parent


        @OneToOne(mappedBy = "foyer")
        @JsonIgnore
        private Universite universite;



//------------------------------------------------------------------


        @OneToMany(mappedBy = "foyer")
        @JsonIgnore
        private Set<Bloc> blocs = new HashSet<>();

    }

