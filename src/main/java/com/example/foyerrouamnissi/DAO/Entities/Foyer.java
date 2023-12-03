package com.example.foyerrouamnissi.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
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


       @OneToOne(mappedBy = "foyer" , fetch = FetchType.LAZY)

        @JsonIgnore
        private Universite universite;



//------------------------------------------------------------------


        @OneToMany
                (cascade = CascadeType.ALL, mappedBy="foyer")
        private Set<Bloc> bloc;
        @OneToMany(mappedBy = "foyer")
        @JsonIgnore
        private Set<Bloc> blocs = new HashSet<>();

    @Transient
    private String universiteName; 





}