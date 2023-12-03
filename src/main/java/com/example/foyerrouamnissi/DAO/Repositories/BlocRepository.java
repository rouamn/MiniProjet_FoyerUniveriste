package com.example.foyerrouamnissi.DAO.Repositories;

import com.example.foyerrouamnissi.DAO.Entities.Bloc;
import com.example.foyerrouamnissi.DAO.Entities.Foyer;
import com.example.foyerrouamnissi.DAO.Entities.Universite;
import lombok.Builder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BlocRepository extends JpaRepository<Bloc ,Long > {
    //select bloc where nom bloc
    Bloc findByNomBloc(String nomBloc);
    List<Bloc> findByFoyer_NomFoyer(String nomFoyer);
    @Query("SELECT b FROM Bloc b " +
            "JOIN b.foyer f " +
            "WHERE LOWER(b.nomBloc) LIKE %:blocName%")

    List<Bloc> searchBlocsByBlocName(@Param("blocName") String blocName);


    @Query("SELECT b FROM Bloc b " +
            "JOIN b.foyer f " +
            "WHERE f.idFoyer = :idfoyer")
    List<Bloc> searchBlocsByIdFoyer(@Param("idfoyer") long idfoyer);




    //List<Bloc> findByCapaciteBloc(Long capaciteBloc);
    // List<Bloc> findByNomBlocAndCapaciteBloc(String nomBloc, Long capaciteBloc);
    //List<Bloc> findByNomBlocIgnoreCase(String nomBloc);
    //List<Bloc> findByCapaciteBlocGreaterThan(Long capaciteBloc);
    //List<Bloc> findByNomBlocContains(String nomBloc);
    //List<Bloc> findAllByNomBlocOrderByNomBlocAsc();
    // List<Bloc> findByNomBlocOrCapaciteBloc(String nomBloc, Long capaciteBloc);
    // List<Bloc> findByFoyer(Foyer foyer);
    // List<Bloc> findByFoyerUniversite(Universite universite);

}
