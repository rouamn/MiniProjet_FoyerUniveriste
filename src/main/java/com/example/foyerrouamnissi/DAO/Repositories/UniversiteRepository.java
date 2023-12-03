package com.example.foyerrouamnissi.DAO.Repositories;

import com.example.foyerrouamnissi.DAO.Entities.Foyer;
import com.example.foyerrouamnissi.DAO.Entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UniversiteRepository  extends JpaRepository<Universite,Long > {
    Universite findByNomUniversite(String nom);





    //roua
            @Query("SELECT u.nomUniversite FROM Universite u WHERE u.foyer = :foyer")
            String findNomUniversiteByFoyer(@Param("foyer") Foyer foyer);
}

