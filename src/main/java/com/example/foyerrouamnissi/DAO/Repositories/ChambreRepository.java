package com.example.foyerrouamnissi.DAO.Repositories;

import com.example.foyerrouamnissi.DAO.Entities.Chambre;
import com.example.foyerrouamnissi.DAO.Entities.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChambreRepository  extends JpaRepository<Chambre,Long > {
    // 1- Recherche par numéro de chambre
    //List<Chambre> findByNumeroChambre(long numeroChambre);

    // 2- Recherche par type de chambre
    //List<Chambre> findByTypeChambre(TypeChambre typeChambre);

    // 3- Recherche des chambres par bloc
    List<Chambre> findByBloc(Chambre bloc);

    // 4- Recherche des chambres par bloc et type de chambre
   // List<Chambre> findByBlocAndTypeChambre(Chambre bloc, TypeChambre typeChambre);

    // 5- Recherche des chambres par numéro de chambre et type de chambre
    //List<Chambre> findByNumeroChambreAndTypeChambre(long numeroChambre, TypeChambre typeChambre);
}
