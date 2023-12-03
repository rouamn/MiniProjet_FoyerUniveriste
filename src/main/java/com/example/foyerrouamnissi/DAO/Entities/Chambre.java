package com.example.foyerrouamnissi.DAO.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="Chambre")



public class Chambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idChambre")

    private long idChambre;

    @Column(name="numeroChambre" ,unique = true)

    private  long numeroChambre;
    @Column(name="TypeChambre")

    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;




    @ManyToOne
    @JoinColumn(name = "id_bloc")
    private Bloc bloc;

    @OneToMany(mappedBy = "chambre", cascade = CascadeType.ALL)
    private Set<Reservation> reservations;


    public Long getBlocId() {
        return bloc != null ? bloc.getIdBloc() : null;
    }
}
