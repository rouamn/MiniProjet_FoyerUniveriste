package com.example.foyerrouamnissi.DAO.Repositories;

import com.example.foyerrouamnissi.DAO.Entities.Foyer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
    Foyer findByNomFoyer(String nomFoyer);

    List<Foyer> findByNomFoyerContainingIgnoreCaseAndCapaciteFoyer(String nomFoyer, long capaciteFoyer);

    long count();

    /* @Query("SELECT f FROM Foyer f LEFT JOIN FETCH f.universite")
     List<Foyer> findAllFoyersWithUniversite();
 */
    @EntityGraph(attributePaths = "universite")
    List<Foyer> findAll();

    @Query("SELECT f FROM Foyer f JOIN FETCH f.universite LEFT JOIN FETCH f.bloc")
    List<Foyer> findFoyersWithUniversiteAndBlocs();

    @Query("SELECT f FROM Foyer f LEFT JOIN FETCH f.universite")
    List<Foyer> findAllFoyersWithUniversiteAndBlocs();


   // Foyer findByNomBloc(String nomBloc);
   // Foyer findByNomUniversite(String nomUniversite);
   @Query("SELECT f FROM Foyer f " +
           "JOIN f.universite u " +
           "WHERE LOWER(f.nomFoyer) LIKE %:foyerName%")
   List<Foyer> searchFoyersByFoyerName(@Param("foyerName") String foyerName);

    @Query("SELECT f FROM Foyer f " +
            "JOIN f.universite u " +
            "WHERE LOWER(u.nomUniversite) LIKE %:universityName%")
    List<Foyer> searchFoyersByUniversite(@Param("universityName") String universityName);
    @Query("SELECT f FROM Foyer f " +
            "JOIN f.bloc b " +
            "WHERE LOWER(b.nomBloc) LIKE %:bloc%")
    List<Foyer> searchFoyersByBloc(@Param("bloc") String bloc);
}