package com.example.foyerrouamnissi.DAO.Repositories;

import com.example.foyerrouamnissi.DAO.Entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversiteRepository  extends JpaRepository<Universite,Long > {
    Universite findByNomUniversite(String nom);
}

