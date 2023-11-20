package com.example.foyerrouamnissi.Services.Etudiant;

import com.example.foyerrouamnissi.DAO.Entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    Etudiant addEtudiant(Etudiant e);
    List<Etudiant> addEtudiants(List<Etudiant> etudiants);
    Etudiant editEtudiant(Integer id, Etudiant e);
    List<Etudiant> findAll();
    Etudiant findById(Integer id);
    void deleteById(Integer id);
    void delete(Etudiant e);


}
