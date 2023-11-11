package com.example.foyerrouamnissi.DAO.Repositories;

import com.example.foyerrouamnissi.DAO.Entities.Bloc;
import com.example.foyerrouamnissi.DAO.Entities.Foyer;
import com.example.foyerrouamnissi.DAO.Entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoyerRepository  extends JpaRepository<Foyer,Long > {
    // 1- Recherche des foyers d'un bloc spécifique
    //List<Foyer> findByBlocs(Bloc bloc);

    // 2- Recherche du foyer par son idFoyer pour un bloc donné
    //Foyer findByIdFoyerAndBlocs(Bloc bloc, long idFoyer);

    // 3- Recherche des foyers d'un bloc ayant une capacité spécifique
    //List<Foyer> findByBlocsCapaciteFoyer(Bloc bloc, long capaciteFoyer);

    // 4- Recherche du foyer d'un bloc spécifique dans une université donnée
    //List<Foyer> findByBlocsAndUniversite(Bloc bloc, Universite universite);
}

