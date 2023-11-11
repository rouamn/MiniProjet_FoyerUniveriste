package com.example.foyerrouamnissi.Services.Universite;

import com.example.foyerrouamnissi.DAO.Entities.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite addUniversite(Universite b);
    List<Universite> addUniversite(List<Universite> b);
    Universite editUniversite(Universite b);
    List<Universite> findAll();
    Universite findById(long id);
    void deleteById(long id);
    void delete(Universite b);
    Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite) ;
    Universite desaffecterFoyerAUniversite(long idUniversite);
}
