package com.example.foyerrouamnissi.DAO.Repositories;

import com.example.foyerrouamnissi.DAO.Entities.Bloc;
import com.example.foyerrouamnissi.DAO.Entities.Foyer;
import com.example.foyerrouamnissi.DAO.Entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface BlocRepository extends JpaRepository<Bloc ,Long > {
    //select bloc where nom bloc
    Bloc findByNomBloc(String nomBloc);
    List<Bloc> findByCapaciteBloc(Long capaciteBloc);
    List<Bloc> findByNomBlocAndCapaciteBloc(String nomBloc, Long capaciteBloc);
    List<Bloc> findByNomBlocIgnoreCase(String nomBloc);
    List<Bloc> findByCapaciteBlocGreaterThan(Long capaciteBloc);
    List<Bloc> findByNomBlocContains(String nomBloc);
    //List<Bloc> findAllByNomBlocOrderByNomBlocAsc();
    List<Bloc> findByNomBlocOrCapaciteBloc(String nomBloc, Long capaciteBloc);
    List<Bloc> findByFoyer(Foyer foyer);
    List<Bloc> findByFoyerUniversite(Universite universite);
    //roua
    @Query("SELECT b FROM Bloc b WHERE b.foyer = :foyer")
    Set<Bloc> getBlocsByFoyer(@Param("foyer") Foyer foyer);

}
