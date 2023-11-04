package com.example.foyerrouamnissi.Services;

import com.example.foyerrouamnissi.DAO.Entities.Bloc;
import com.example.foyerrouamnissi.DAO.Entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    Etudiant addEtudiant(Etudiant b);
    List< Etudiant> addEtudiants(List<Etudiant> b);
    Etudiant editEtudiant(Etudiant b);
    List<Etudiant> findAll();
    Etudiant findById(long id);
    void deleteById(long id);
    void delete(Etudiant b);
}
